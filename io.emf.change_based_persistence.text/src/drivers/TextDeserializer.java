/*
 * TO DO:
 * Throw proper exceptions
 */
package drivers;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import change.ChangeLog;

public class TextDeserializer 
{
	private final String classname = this.getClass().getSimpleName();
	private EPackage ePackage = null;
	private ChangeLog changelog;
	private double counter = 0;
	
	private enum EventType
	{
		SET_A,
		UNSET_A,
		ADD_R,
	    CREATE,
		SET_R,
		DEL_R,
		UNSET_R,
		NULL;
	}
	private final String RESOURCE_NAME = "DeltaResourceImpl";
	private PersistenceManager persistenceManager;
	//private String fileLocation;
	
	public TextDeserializer(PersistenceManager persistenceManager, ChangeLog aChangeLog)
	{
		this.persistenceManager = persistenceManager;
		this.changelog = aChangeLog;
	}
	
	public void load(Map<?,?> options) throws IOException
	{
		//fileLocation = (String)options.get("FILE_LOCATION");
		
		BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(persistenceManager.getURI().path()), persistenceManager.TEXT_ENCODING));
		
		String line;
		
		
		if((line = br.readLine()) != null)
		{
			ePackage = loadMetamodel(getNthWord(line,2));
		}
		else
		{
			System.out.println(classname+" Error, file empty");
			System.exit(0);
		}
		
		while((line = br.readLine()) != null)
		{
			//System.out.println(line);
			StringTokenizer st = new StringTokenizer(line);
			
			EventType eventType = EventType.NULL;
			
			if(st.hasMoreElements())
			{ 
				  eventType = EventType.valueOf
						 (st.nextElement().toString());
			} 
			
			/* Switches over various event types, calls appropriate handler method*/
			switch(eventType)
			{
			case CREATE:
				handleCreateEvent(line);
				break;
			case SET_A:
				handleSetEAttributeEvent(line);
				break;
			case SET_R:
				handleSetEReferenceEvent(line);
				break;
			case UNSET_A: 
				handleUnsetEAttributeEvent(line);
				break;
			case UNSET_R:
				handleUnsetEReferenceEvent(line);
				break;
			case ADD_R:
				handleAddToResourceEvent(line);
				break;
			case DEL_R:
				handleRemoveFromResourceEvent(line);
				break;
			case NULL:
				break;
			default:
				break;
			}	
		}
		br.close();
	}
	
	private void handleSetEReferenceEvent(String line)
	{
		EObject focus_obj = changelog.getEObject(Double.valueOf(getNthWord(line,4)));
		EReference ref = (EReference) focus_obj.eClass().getEStructuralFeature(getNthWord(line,2));
		
		String[] feature_values_array = createArrayFromString(getValue(line));
		
		if(ref.isMany())
		{
			@SuppressWarnings("unchecked")
			EList<EObject> feature_value_list = (EList<EObject>) focus_obj.eGet(ref);
			
			for(String str : feature_values_array)
			{
				feature_value_list.add(changelog.getEObject(Double.valueOf(getNthWord(str,2))));
			}
		}
		else
		{
			focus_obj.eSet(ref, changelog.getEObject(Double.valueOf(getNthWord(feature_values_array [0],2))));
		}
	}
	
	private void handleUnsetEReferenceEvent(String line)
	{
		EObject focus_obj = changelog.getEObject(Double.valueOf(getNthWord(line,4)));
		
		EReference ref = (EReference) focus_obj.eClass().getEStructuralFeature(getNthWord(line,2));
		
		if(ref.isMany())
		{
			String[] feature_values_array = createArrayFromString(getValue(line));
			
			@SuppressWarnings("unchecked")
			EList<EObject> feature_value_list = (EList<EObject>) focus_obj.eGet(ref);
			
			for(String str : feature_values_array)
			{
				feature_value_list.remove(changelog.getEObject(Double.valueOf(getNthWord(str,2))));				
			}
		}
		else
		{
			focus_obj.eUnset(ref);
		}
	}
	
	private void handleSetEAttributeEvent(String line) 
	{
		EObject focus_obj = changelog.getEObject(Double.valueOf(getNthWord(line,4)));
		EAttribute attr = (EAttribute)focus_obj.eClass().getEStructuralFeature(getNthWord(line,2));
		
		String[] feature_values_array = createArrayFromString(getValue(line));
		
		if(attr.isMany())
		{
			@SuppressWarnings("unchecked")
			EList<Object> feature_value_list = (EList<Object>) focus_obj.eGet(attr);  //change nam of var!
			
			for(String str : feature_values_array)
			{
				if(str.equals("null"))
					feature_value_list.add(null);
				else
					feature_value_list.add(EcoreUtil.createFromString(attr.getEAttributeType(),str));
			}
		}
		else
		{
			if(feature_values_array [0].equals("null"))
				focus_obj.eSet(attr, null);
			else
				focus_obj.eSet(attr, EcoreUtil.createFromString(attr.getEAttributeType(),feature_values_array [0]));
		}
	}
	

	
	private void handleAddToResourceEvent(String line)
	{
		String[] obj_str_array = createArrayFromString(getValue(line));
		
		for(String str : obj_str_array)
		{
			EObject obj = changelog.getEObject(Double.valueOf(getNthWord(str,2)));
			persistenceManager.addEObjectToContents(obj);
		}
	}
	
	private void handleRemoveFromResourceEvent(String line)
	{
		String[] obj_str_array = createArrayFromString(getValue(line));
		
		for(String str : obj_str_array)
		{
			EObject obj = changelog.getEObject(Double.valueOf(getNthWord(str,2)));
			persistenceManager.removeEObjectFromContents(obj);
		}
	}
	
	private void handleCreateEvent(String line)
	{
		String[] obj_str_array = createArrayFromString(getValue(line));
		for(String str : obj_str_array)
		{
			Double id = Double.valueOf(getNthWord(str,2));
			EObject obj = createEObject(getNthWord(str,1));
			changelog.addObjectToMap(obj, id);
			updateCounter(id);	
		}
	}
	
	
	private void handleUnsetEAttributeEvent(String line)
	{
		double obj_id = Double.valueOf(getNthWord(line,4));
		
		EObject obj = changelog.getEObject(obj_id);
		
		EAttribute attr = (EAttribute) obj.eClass().getEStructuralFeature(getNthWord(line,2));
		
		if(attr.isMany())
		{
			EList<Object> attrValueList = (EList<Object>) obj.eGet(attr);  //change nam of var!
			String[] obj_attr_str_array = createArrayFromString(getValue(line));
			
			for(String str : obj_attr_str_array)
			{
				attrValueList.remove(EcoreUtil.createFromString(attr.getEAttributeType(),str));
			}
		}
		else
		{
			obj.eUnset(attr);
		}
	}
	
	private EPackage loadMetamodel(String metamodelURI)
	{
		//EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage("http://io.emf.change_based_persistence.text");
		EPackage ePackage = null;
		if(EPackage.Registry.INSTANCE.containsKey(metamodelURI))
			ePackage = EPackage.Registry.INSTANCE.getEPackage(metamodelURI);
		else
		{
			System.out.println(classname+" could not load metamodel!");
			System.exit(0);
		}
		return ePackage;
	}
	
	private void handleAddEvent(String line)
	{
		if(getNthWord(line,4).equals(RESOURCE_NAME)) //add object directly to resource
		{
			EObject eObject = ePackage.getEFactoryInstance().create((EClass) ePackage.getEClassifier(getNthWord(line,2)));
			persistenceManager.addEObjectToContents(eObject);
		}
	}
	
	//should check for errors here
	private EObject createEObject(String eClassName) //does this need to be a method?
	{
		return ePackage.getEFactoryInstance().create((EClass)
				ePackage.getEClassifier(eClassName));
	}
	
	private void updateCounter(Double d)
	{
		if(d > counter)
			counter = d;
	}
	
	private String getNthWord(String input, int n)
	{
		String [] stringArray = input.split(" ");
		if(n-1 < stringArray.length)
			return stringArray[n-1];
		return null;
	}
	
	private String[] createArrayFromString(String input)
	{
		String str = input;
		String [] stringArray;
		
		//str = input.substring(0, input.length() -1); //remove [ and ]	
		stringArray = str.split(",");
		
		/*for(int i = 0; i < stringArray.length; i++)
		{
			stringArray[i] = stringArray[i].trim(); //remove trailing / leading white spaces
		}*/
		
	    return stringArray;
	}
	private String getValue(String str)
	{
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(str);
		
		String result = "";
		
		if(m.find())
			result = m.group(1);
		return result;
	}
}
