
package impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import change.ChangeLog;
import change.EventAdapter;

import drivers.PersistenceManager;


public class DeltaResourceImpl extends ResourceImpl implements DeltaResource
{
	private  final String classname = this.getClass().getSimpleName();
	private final ChangeLog changeLog;
    private PersistenceManager persistenceManager;
    EventAdapter eventAdapter;
	
    public DeltaResourceImpl(URI uri)
	{
		super(uri);
		
		changeLog = new ChangeLog();
	
		eventAdapter = new EventAdapter(changeLog);
		this.eAdapters().add(eventAdapter); 
		
		persistenceManager = new PersistenceManager(changeLog,this); //is changelog variable pointing to same changelog as adapter?
	}
    
    public DeltaResourceImpl()
    {
    	changeLog = new ChangeLog();
    	
		eventAdapter = new EventAdapter(changeLog);
		this.eAdapters().add(eventAdapter); 
		
		persistenceManager = new PersistenceManager(changeLog,this); //is changelog variable pointing to same changelog as adapter?
    }

	@Override
	public void save(Map<?, ?> options)
	{
		persistenceManager.save(options);
		
		/*If save file exists, print contents to console*/
		File f = new File(this.uri.path());
		
		if(f.exists() && !f.isDirectory())
		{
			System.out.println("DeltaResourceImpl: Print save file contents : ");
			
			try
			{
				BufferedReader in = new BufferedReader(new InputStreamReader(
						new FileInputStream(this.uri.path()),"Ascii"));
				String line;
				
				while((line = in.readLine())!= null)
				{
					System.out.println(line);
				}
				in.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void load(Map<?, ?> options)throws IOException
	{
		eventAdapter.setEnabled(false);
		
		System.out.println(classname+": Load called!");
		
		try {
			persistenceManager.load(options);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		eventAdapter.setEnabled(true);
	}
		
	public ChangeLog getChangeLog()
	{
		return this.changeLog;
	}
	
}
