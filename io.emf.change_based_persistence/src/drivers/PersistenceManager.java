
//todo: specify encoding ?
//http://www.javapractices.com/topic/TopicAction.do?Id=31
package drivers;

import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;


import change.ChangeLog;
import impl.DeltaResourceImpl;

public class PersistenceManager 
{
	private final ChangeLog changeLog; 

	private final DeltaResourceImpl resource;
	public final String TEXT_ENCODING = "Ascii";
	public static final String DELIMITER = ","; //,
	public static final String ESCAPE_CHAR ="+"; //*
    private boolean resume = false;


	public PersistenceManager(ChangeLog aChangeLog, DeltaResourceImpl resource)
	{
		this.changeLog = aChangeLog;
		this.resource = resource;
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

	
	//when the logic gets more complex, this is moving to its own serializer class.
	public void save(Map<?,?> options)
	{
		TextSerializer serializer = new TextSerializer(this, changeLog);
		serializer.save(options);
	}

	
	public void load(Map<?,?> options) throws Exception
	{	
		
		TextDeserializer textDeserializer = new TextDeserializer(this,changeLog);
		textDeserializer.load(options);
	}
	
	/*public DeltaResourceImpl getResource()
	{
		return this.resource;
	}*/
	
	public ChangeLog getChangeLog()
	{
		return this.changeLog;
	}
}
