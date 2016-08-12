
//todo: specify encoding ?
//http://www.javapractices.com/topic/TopicAction.do?Id=31
package drivers;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import change.ChangeLog;
import impl.DeltaResourceImpl;

public class PersistenceManager 
{
	private final ChangeLog changeLog; 

	private final DeltaResourceImpl resource;
	public final String TEXT_ENCODING = "Ascii";
	public final String DELIMITER = ","; //,
	public final String ESCAPE_CHAR ="+"; //*
	
	public PersistenceManager(ChangeLog aChangeLog, DeltaResourceImpl resource)
	{
		this.changeLog = aChangeLog;
		this.resource = resource;
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

	
	public void load(Map<?,?> options) throws IOException
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