package drivers;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;

import change.Changelog;
import exceptions.UnknownPackageException;
import gnu.trove.map.TIntObjectMap;
import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TIntObjectHashMap;

public class CBPBinaryDeserializer 
{
	private final String classname = this.getClass().getSimpleName();
	private EPackage ePackage = null;
	private final Changelog changelog;
	
	private final TIntObjectMap<EObject> IDToEObjectMap = 
			new TIntObjectHashMap<EObject>();
	
	private final PersistenceManager manager;
    private final EPackageElementsNamesMap ePackageElementsNamesMap;
    private final Charset STRING_ENCODING = StandardCharsets.UTF_8;
    
    private final TObjectIntMap<String> simpleTypeNameMap;
    
    public CBPBinaryDeserializer(PersistenceManager manager, Changelog aChangelog,
            EPackageElementsNamesMap ePackageElementsNamesMap,TObjectIntMap<String>   simpleTypeNameMap)
    {
    	 this.manager = manager;
         this.changelog = aChangelog;
         this.ePackageElementsNamesMap = ePackageElementsNamesMap;
         this.simpleTypeNameMap = simpleTypeNameMap;
    }
    
    public void load(Map<?,?> options) throws Exception
    { 
    	InputStream inputStream = new BufferedInputStream
				(new FileInputStream(manager.getURI().path()));
		
    	/*Read File Header*/
		 inputStream.skip(11); // skip file header
		
		/*Load metamodel*/
		int nsUriLength = readInt(inputStream);
		loadMetamodel(readString(inputStream,nsUriLength));
		
		/*Read binary records*/
		while(inputStream.available()> 0)
		{
			switch (readInt(inputStream))
			{
			case PersistenceManager.CREATE_AND_ADD_TO_RESOURCE:
				handleCreateAndAddToResource(inputStream);
				break;
			case PersistenceManager.CREATE_AND_SET_EREFERENCE_VALUE:
				handeCreateAndSetEReferenceValue(inputStream);
				break;
			case PersistenceManager.ADD_TO_RESOURCE:
				handleAddToResource(inputStream);
				break;
			case PersistenceManager.DELETE_FROM_RESOURCE:
				handleRemoveFromResource(inputStream);
				break;
			case PersistenceManager.SET_EREFERENCE_VALUE:
				handleSetEReference(inputStream);
				break;
			case PersistenceManager.UNSET_EREFERENCE_VALUE:
				handleUnsetEReferenceValue(inputStream);
				break;
			case PersistenceManager.SET_COMPLEX_EATTRIBUTE_VALUE:
				handleSetComplexEAttributeValue(inputStream);
				break;
			case PersistenceManager.UNSET_COMPLEX_EATTRIBUTE_VALUE:
				handleUnsetComplexEAttributeValue(inputStream);
				break;
			case PersistenceManager.SET_PRIMITIVE_EATTRIBUTE_VALUE:
				handleSetPrimitiveEAttributeType(inputStream);
				break;
			case PersistenceManager.UNSET_PRIMITIVE_EATTRIBUTE_VALUE:
				handleUnsetPrimitiveEAttributeType(inputStream);
				break;
			}
		}
		
		inputStream.close();	
    }
    
    private int getTypeID(EDataType type)
    {
    	if(simpleTypeNameMap.containsKey(type.getName()))
    	{
    		return simpleTypeNameMap.get(type.getName());
    	}
    	
    	return PersistenceManager.COMPLEX_TYPE;
    }
    
    private void handleUnsetPrimitiveEAttributeType(InputStream in) throws IOException
    {
EObject focus_obj = IDToEObjectMap.get(readInt(in));
    	
    	EAttribute attr = (EAttribute) focus_obj.eClass().getEStructuralFeature
				(ePackageElementsNamesMap.getName(readInt(in)));
    	
    	EDataType type = attr.getEAttributeType();
    	
    	int primitiveSize = -1;
    	int primitiveType = -1;
    	
    	switch(getTypeID(type))
    	{
    	case PersistenceManager.SIMPLE_TYPE_INT:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_INT;
    		primitiveSize = manager.INTEGER_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_SHORT:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_SHORT;
    		primitiveSize = manager.SHORT_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_LONG:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_LONG;
    		primitiveSize = manager.LONG_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_FLOAT:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_FLOAT;
    		primitiveSize = manager.FLOAT_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_DOUBLE:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_DOUBLE;
    		primitiveSize = manager.DOUBLE_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_BOOLEAN:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_BOOLEAN;
    		primitiveSize = manager.INTEGER_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_CHAR:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_CHAR;
    		primitiveSize = manager.CHAR_SIZE;
    		return;
    	}
    	
    	int numPrimitives = readInt(in);
    	
    	Object[] featureValuesArray = new Object[numPrimitives];
    	
    	byte[] buffer = new byte[numPrimitives * primitiveSize];
    	
    	in.read(buffer);
    	
    	int index = 0;
    	
    	for(int i = 0; i < numPrimitives; i++)
    	{
    		featureValuesArray[i] = byteArrayToPrimitive(Arrays.copyOfRange(buffer, index, index+primitiveSize),primitiveType);
    		
    		index = index + primitiveSize;
    	}
    	
    	if(primitiveType == PersistenceManager.SIMPLE_TYPE_BOOLEAN)
    	{
    		boolean b = true;
    		
    		if(attr.isMany())
    		{
    			@SuppressWarnings("unchecked")
                EList<Object> feature_value_list = (EList<Object>) focus_obj.eGet(attr);  
    			
    			for(Object obj : featureValuesArray)
    			{
    				if((int)obj == 0)
    					b = false;
    				
    				feature_value_list.remove(b);
    			}
    		}
    		else
    		{
    			focus_obj.eUnset(attr);
    		}
    	}
    	else
    	{
    		if(attr.isMany())
    		{
        		@SuppressWarnings("unchecked")
                EList<Object> feature_value_list = (EList<Object>) focus_obj.eGet(attr);  
        		
    			for(Object obj : featureValuesArray)
    			{
    				feature_value_list.remove(obj);
    			}
    		}
    		else
    		{
    			focus_obj.eUnset(attr);
    		}
    	}
    }
    private void handleSetPrimitiveEAttributeType(InputStream in) throws IOException //combine set and unset
    {
    	EObject focus_obj = IDToEObjectMap.get(readInt(in));
    	
    	EAttribute attr = (EAttribute) focus_obj.eClass().getEStructuralFeature
				(ePackageElementsNamesMap.getName(readInt(in)));
    	
    	EDataType type = attr.getEAttributeType();
    	
    	int primitiveSize = -1;
    	int primitiveType = -1;
    	
    	switch(getTypeID(type))
    	{
    	case PersistenceManager.SIMPLE_TYPE_INT:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_INT;
    		primitiveSize = manager.INTEGER_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_SHORT:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_SHORT;
    		primitiveSize = manager.SHORT_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_LONG:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_LONG;
    		primitiveSize = manager.LONG_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_FLOAT:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_FLOAT;
    		primitiveSize = manager.FLOAT_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_DOUBLE:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_DOUBLE;
    		primitiveSize = manager.DOUBLE_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_BOOLEAN:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_BOOLEAN;
    		primitiveSize = manager.INTEGER_SIZE;
    		break;
    	case PersistenceManager.SIMPLE_TYPE_CHAR:
    		primitiveType = PersistenceManager.SIMPLE_TYPE_CHAR;
    		primitiveSize = manager.CHAR_SIZE;
    		return;
    	}
    	
    	int numPrimitives = readInt(in);
    	
    	Object[] featureValuesArray = new Object[numPrimitives];
    	
    	byte[] buffer = new byte[numPrimitives * primitiveSize];
    	
    	in.read(buffer);
    	
    	int index = 0;
    	
    	for(int i = 0; i < numPrimitives; i++)
    	{
    		featureValuesArray[i] = byteArrayToPrimitive(Arrays.copyOfRange(buffer, index, index+primitiveSize),primitiveType);
    		
    		index = index + primitiveSize;
    	}
    	
    	if(primitiveType == PersistenceManager.SIMPLE_TYPE_BOOLEAN)
    	{
    		boolean b = true;
    		
    		if(attr.isMany())
    		{
    			@SuppressWarnings("unchecked")
                EList<Object> feature_value_list = (EList<Object>) focus_obj.eGet(attr); 
    			
    			for(Object obj : featureValuesArray)
    			{
    				if((int)obj == 0)
    					b = false;
    				
    				feature_value_list.add(b);
    			}
    		}
    		else
    		{
    			if((int)featureValuesArray[0] == 0)
    				b = false;
    			
    			focus_obj.eSet(attr,b);
    		}
    	}
    	else
    	{
    		
    		if(attr.isMany())
    		{
    			@SuppressWarnings("unchecked")
                EList<Object> feature_value_list = (EList<Object>) focus_obj.eGet(attr);  
    			
    			for(Object obj : featureValuesArray)
    			{
    				feature_value_list.add(obj);
    			}
    		}
    		else
    		{
    			focus_obj.eSet(attr,featureValuesArray[0]);
    		}
    	}
    }
    
    private void handleUnsetComplexEAttributeValue(InputStream in) throws IOException
    {
    	EObject focus_obj = IDToEObjectMap.get(readInt(in));
    	
    	EAttribute attr = (EAttribute) focus_obj.eClass().getEStructuralFeature
				(ePackageElementsNamesMap.getName(readInt(in)));
    
    	int numStrings = readInt(in);
    	
    	String[] feature_values_array = new String[numStrings];
    	
    	for(int i = 0; i < numStrings; i++)
    	{
    		int numBytes = readInt(in);
    		
    		feature_values_array[i] = readString(in,numBytes);
    	}
    	
    	if(attr.isMany())
    	{
    		@SuppressWarnings("unchecked")
			EList<Object> feature_value_list = (EList<Object>)focus_obj.eGet(attr);
    		
			for(String str : feature_values_array)
			{
				feature_value_list.remove(EcoreUtil.createFromString(attr.getEAttributeType(), str));
			}
    	}
    	else
    	{
    		focus_obj.eUnset(attr);
    	}
    }
    
    private void handleSetComplexEAttributeValue(InputStream in) throws IOException
    {
    	EObject focus_obj = IDToEObjectMap.get(readInt(in));
    	
    	EAttribute attr = (EAttribute) focus_obj.eClass().getEStructuralFeature
				(ePackageElementsNamesMap.getName(readInt(in)));
    
    	int numStrings = readInt(in);
    	
    	String[] feature_values_array = new String[numStrings];
    	
    	for(int i = 0; i < numStrings; i++)
    	{
    		int numBytes = readInt(in);
    		
    		feature_values_array[i] = readString(in,numBytes);
    	}
    	
    	if(attr.isMany())
    	{
    		@SuppressWarnings("unchecked")
			EList<Object> feature_value_list = (EList<Object>)focus_obj.eGet(attr);
    		
			for(String str : feature_values_array)
			{
				if(str.equals(manager.NULL_STRING))
					feature_value_list.add(null);
				
				else
					feature_value_list.add(EcoreUtil.createFromString(attr.getEAttributeType(), str));
			}
    	}
    	else
    	{
    		if(feature_values_array [0].equals(manager.NULL_STRING))
                focus_obj.eSet(attr, null);
    		
            else
                focus_obj.eSet(attr, EcoreUtil.createFromString(attr.getEAttributeType(),feature_values_array [0]));
    	}
    }
    private void handleUnsetEReferenceValue(InputStream in) throws IOException
    {
    	EObject focus_obj = IDToEObjectMap.get(readInt(in));
    	
    	EReference ref = (EReference) focus_obj.eClass().getEStructuralFeature
				(ePackageElementsNamesMap.getName(readInt(in)));
    	
    	int numInts = readInt(in);
    	
    	byte[] buffer = new byte[numInts * 4];
    	
    	in.read(buffer);
    	
    	int[] intArray = new int[numInts]; //stores 'n' numbers
    	
    	int index = 0;
    	
    	for(int i = 0; i < numInts; i++)
    	{
    		intArray[i] = byteArrayToInt(Arrays.copyOfRange(buffer, index,index+4));
    		
    		index = index + 4;
    	}
    	
    	if(ref.isMany())
    	{
    		@SuppressWarnings("unchecked")
			EList<EObject> feature_value_list = (EList<EObject>) focus_obj.eGet(ref);
    		
    		for(int i : intArray)
    		{
    			feature_value_list.remove(IDToEObjectMap.remove(i));
    		}
    	}
    	else
    	{
    		focus_obj.eUnset(ref);
    	}
    	
    }
    private void handleRemoveFromResource(InputStream in) throws IOException
    {
    	int numInts = readInt(in);
    	
    	byte[] buffer = new byte[numInts * 4];
    	
    	in.read(buffer);
    	
    	int index = 0;
    	
    	for(int i = 0; i < numInts; i++)
    	{
    		int id = byteArrayToInt(Arrays.copyOfRange(buffer, index,index+4));
    		
    		manager.removeEObjectFromContents(IDToEObjectMap.remove(id));
    		
    		index = index + 4;
    	}
    }
    
    private void handleSetEReference(InputStream in) throws IOException
    {
    	EObject focus_obj = IDToEObjectMap.get(readInt(in));
    	
    	EReference ref = (EReference) focus_obj.eClass().getEStructuralFeature
				(ePackageElementsNamesMap.getName(readInt(in)));
    	
    	int numInts = readInt(in);
    	
    	byte[] buffer = new byte[numInts * 4]; //stores bytes for all 'n' numbers
    	
    	in.read(buffer); //read in bytes for all 'n' numbers
    	
    	int[] intArray = new int[numInts]; //stores 'n' numbers
    	
    	int index = 0;
    	
    	for(int i = 0; i < numInts; i++)
    	{
    		intArray[i] = byteArrayToInt(Arrays.copyOfRange(buffer, index,index+4));
    		
    		index = index + 4;
    	}
    	
    	if(ref.isMany())
    	{
    		@SuppressWarnings("unchecked")
			EList<EObject> feature_value_list = (EList<EObject>) focus_obj.eGet(ref);
    		
    		for(int i : intArray)
    		{
    			feature_value_list.add(IDToEObjectMap.get(i));
    		}
    	}
    	else
    	{
    		focus_obj.eSet(ref, IDToEObjectMap.get(intArray[0]));
    	}
    }
    
    
    private void handleCreateAndAddToResource(InputStream in) throws IOException
    {
    	int numInts = readInt(in);
    	
    	byte[] buffer = new byte[numInts * 4]; //stores bytes for all 'n' numbers
    	
    	in.read(buffer);
    	
    	int[] intArray = new int[numInts]; //stores 'n' numbers
    	
    	int index = 0;
    	
    	for(int i = 0; i < numInts; i++)
    	{
    		intArray[i] = byteArrayToInt(Arrays.copyOfRange(buffer, index,index+4));
    		
    		index = index + 4;
    	}
    	
    	index = 0;
    	
    	for(int i = 0; i < (numInts / 2); i++)
    	{
    		EObject obj = createEObject(ePackageElementsNamesMap.getName(intArray[index]));
    		
    		int id = intArray[index+1];
    		
    		index = index + 2;
    		
    		changelog.addObjectToMap(obj, id);
    		IDToEObjectMap.put(id,obj);
    		
    		manager.addEObjectToContents(obj);
    	}
    }
    
    private void handeCreateAndSetEReferenceValue(InputStream in) throws IOException
    {
    	EObject focus_obj = IDToEObjectMap.get(readInt(in));
    	
    	EReference ref = (EReference) focus_obj.eClass().getEStructuralFeature
                (ePackageElementsNamesMap.getName(readInt(in)));
    	
    	int numInts = readInt(in);
    	
    	byte[] buffer = new byte[numInts * 4]; //stores 'n' numbers
    	
    	in.read(buffer); //read in bytes for 'n' numbers
    	
    	int[] intArray = new int[numInts]; //stores 'n' numbers
    	
    	int index = 0;
    	
    	for(int i = 0; i < numInts; i++)
    	{
    		intArray[i] = byteArrayToInt(Arrays.copyOfRange(buffer, index,index+4));
    		
    		index = index + 4;
    	}
    	
    	index = 0;
    	
    	for(int i = 0; i < (numInts / 2); i++)
    	{
    		EObject obj = createEObject(ePackageElementsNamesMap.getName(intArray[index]));
    		
    		int id = intArray[index + 1];
    		
    		index = index + 2;
    		
    		changelog.addObjectToMap(obj, id);
   
    		IDToEObjectMap.put(id,obj);
    	}
    	
    	if(ref.isMany())
    	{
    		@SuppressWarnings("unchecked")
			EList<EObject> feature_value_list = (EList<EObject>) focus_obj.eGet(ref);
    		
    		for(int i = 1; i < numInts; i = i + 2)
    		{
    			feature_value_list.add(IDToEObjectMap.get(intArray[i]));
    		}
    	}
    	else
    	{
    		focus_obj.eSet(ref, IDToEObjectMap.get(intArray[1]));
    	}
    	
    }
    
    private void handleAddToResource(InputStream in) throws IOException
    {
    	int numInts = readInt(in);
    	
    	byte[] buffer = new byte[numInts * 4]; //stores 'n' numbers
    	
    	in.read(buffer); //read in bytes for 'n' numbers
    	
    	int startIndex = 0;
    	
    	for(int i = 0; i < numInts; i++)
    	{
    		int id = byteArrayToInt(Arrays.copyOfRange(buffer, startIndex,startIndex + manager.INTEGER_SIZE));
    		
    		startIndex = startIndex + manager.INTEGER_SIZE;
    		
    		manager.addEObjectToContents(IDToEObjectMap.get(id));
    	}
    }
    
    private void loadMetamodel(String metamodelURI) throws UnknownPackageException
    {
    	
        if(EPackage.Registry.INSTANCE.containsKey(metamodelURI))
            ePackage = EPackage.Registry.INSTANCE.getEPackage(metamodelURI);
        
        else
            throw new UnknownPackageException(metamodelURI);
        
    }
    
    private EObject createEObject(String eClassName) 
	{
		return ePackage.getEFactoryInstance().create((EClass)
				ePackage.getEClassifier(eClassName));
	}
    
    private String readString(InputStream in, int length) throws IOException
    {
    	byte[] bytes = new byte[length];
    	in.read(bytes);
    	
    	return new String(bytes, STRING_ENCODING);
    }
    
    private Object byteArrayToPrimitive(byte[] bytes,int primitiveType)
    {
    	switch(primitiveType)
    	{
    	case PersistenceManager.SIMPLE_TYPE_BOOLEAN:
    		return byteArrayToInt(bytes);
    	case PersistenceManager.SIMPLE_TYPE_BYTE:
    		return byteArrayToByte(bytes);
    	case PersistenceManager.SIMPLE_TYPE_CHAR:
    		return byteArrayToChar(bytes);
    	case PersistenceManager.SIMPLE_TYPE_DOUBLE:
    		return byteArrayToDouble(bytes);
    	case PersistenceManager.SIMPLE_TYPE_FLOAT:
    		return byteArrayToFloat(bytes);
    	case PersistenceManager.SIMPLE_TYPE_LONG:
    		return byteArrayToLong(bytes);
    	case PersistenceManager.SIMPLE_TYPE_INT:
    		return byteArrayToInt(bytes);
    	case PersistenceManager.SIMPLE_TYPE_SHORT:
    		return byteArrayToShort(bytes);
    	}
    	return null;
    }
    
    private int byteArrayToInt(byte[] bytes)
    {
    	return ByteBuffer.wrap(bytes).getInt();
    }
    
    private byte byteArrayToByte(byte[] bytes)
    {
    	return ByteBuffer.wrap(bytes).get();
    }
    
    private char byteArrayToChar(byte[] bytes)
    {
    	return ByteBuffer.wrap(bytes).getChar();
    }
    
    private double byteArrayToDouble(byte[] bytes)
    {
    	return ByteBuffer.wrap(bytes).getDouble();
    }
    
    private float byteArrayToFloat(byte[] bytes)
    {
    	return ByteBuffer.wrap(bytes).getFloat();
    }
    
    private long byteArrayToLong(byte[] bytes)
    {
    	return ByteBuffer.wrap(bytes).getLong();
    }
    
    private short byteArrayToShort(byte[] bytes)
    {
    	return ByteBuffer.wrap(bytes).getShort();
    }
    
    private int readInt(InputStream in) throws IOException
    {
    	byte[] bytes = new byte[manager.INTEGER_SIZE];
    	in.read(bytes);
    	
    	return ByteBuffer.wrap(bytes).getInt();
    }
}
