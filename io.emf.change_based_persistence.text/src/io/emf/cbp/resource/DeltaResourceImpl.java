package io.emf.cbp.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import io.emf.cbp.text.change.ChangeLog;
import io.emf.cbp.text.change.CreateObjectEntry;
import io.emf.cbp.text.change.InitialEntry;
import main.PersistenceManager;


public class DeltaResourceImpl extends ResourceImpl
{
	private final ChangeLog changeLog = ChangeLog.INSTANCE;
    private PersistenceManager persistenceManager;
	
	private boolean initEntryAdded = false;
	
	
	protected void doSave(OutputStream outputStream, Map< ? , ? > options) throws IOException
	{
		persistenceManager = new PersistenceManager(changeLog);
		persistenceManager.save();
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map< ? , ? > options) throws IOException
	{
		System.out.println("Load!");
	}
	
	//called when object is added to resource, directly or indirectly.
	@Override
	public void attached(EObject eObject) 
	{
		super.attached(eObject);
		
		if(!initEntryAdded)
			addChangeLogInitialEntry(eObject);
		
			
		
		
		//System.out.println(eObject.getClass().getSimpleName()+" Object attached to le resource");
	}
	
	private void addChangeLogInitialEntry(EObject eObject)
	{
		changeLog.addEvent(new InitialEntry(eObject));
		initEntryAdded = true;
	}
	
	private void addChangeLogCreateObjectEntry(EObject eObject)
	{
		changeLog.addEvent(new CreateObjectEntry(eObject));
	}
}
