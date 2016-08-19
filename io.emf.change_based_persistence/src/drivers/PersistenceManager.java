
//todo: specify encoding ?
//http://www.javapractices.com/topic/TopicAction.do?Id=31
package drivers;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import change.Changelog;
import impl.DeltaResourceImpl;

public class PersistenceManager 
{
	public static final int CREATE_AND_ADD_TO_RESOURCE = 0;
	public static final int CREATE_AND_SET_EREFERENCE_VALUE = 1;
    public static final int ADD_TO_RESOURCE = 2;
    public static final int SET_EATTRIBUTE_VALUE = 3;
    public static final int SET_EREFERENCE_VALUE = 4;
    public static final int DELETE_FROM_RESOURCE = 5;
    public static final int UNSET_EATTRIBUTE_VALUE = 6;
    public static final int UNSET_EREFERENCE_VALUE = 7;
    
	public static final String DELIMITER = ","; 
	public static final String ESCAPE_CHAR ="+"; 
	public static final String TEXT_ENCODING = "Ascii";
	
	private final Changelog changelog; 

	private final DeltaResourceImpl resource;
	
    private final EPackageElementsNamesMap ePackageElementsNamesMap;
	
	private boolean resume = false;
    
	public PersistenceManager(Changelog changelog, DeltaResourceImpl resource, 
			EPackageElementsNamesMap ePackageElementsNamesMap)
	{
		this.changelog = changelog;
		this.resource = resource;
		this.ePackageElementsNamesMap = ePackageElementsNamesMap;
	}
	
	public void setResume(boolean b)
	{
		resume = b;
	}
	
	public boolean isResume()
	{
		return resume;
	}
	
	public boolean addEObjectsToContents(List<EObject> objects)
	{
		return resource.getContents().addAll(objects);
	}
	
	public boolean removeEObjectsFromContents(List<EObject> objects)
	{
		return resource.getContents().removeAll(objects);
	}
	
	public boolean addEObjectToContents(EObject object)
	{
		return resource.getContents().add(object);
	}
	
	public boolean removeEObjectFromContents(EObject obj)
	{
		return resource.getContents().remove(obj);
	}
	
	public Resource getResource()
	{
		return this.resource;
	}
	
	public URI getURI()
	{
		return resource.getURI();
	}

	public void save(Map<?,?> options)
	{
		TextSerializer serializer = new TextSerializer(this, changelog,ePackageElementsNamesMap);
		serializer.save(options);
	}

	
	public void load(Map<?,?> options) throws Exception
	{	
		TextDeserializer textDeserializer = new TextDeserializer(this,changelog,ePackageElementsNamesMap);
		textDeserializer.load(options);
	}
	
	public Changelog getChangelog()
	{
		return this.changelog;
	}
}
