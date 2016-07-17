package drivers;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.ecore.EObject;

import change.AbstractEntry;
import change.AddToResourceEntry;
import change.InitialEntry;

public class TextSerializer 
{
	private PersistenceManager manager;
	private List<String> outputList;
	
	public TextSerializer(PersistenceManager manager)
	{
		this.manager =  manager;
		outputList = new ArrayList<String>();
	}
	
	public void save(Map<?,?> options)
	{
		//String fileSaveLocation = (String) options.get("FILE_SAVE_LOCATION");
		for(AbstractEntry e : manager.getResource().getChangeLog().getEventsList() )
		{
			if(e instanceof InitialEntry)  //should be if else
				createInitialEntry(e.getEObject());
			if(e instanceof AddToResourceEntry)
			{
				serialiseAddObjectToResourceE(e.getEObject(),e.getUUID());
			}
		}
		
		//finally append strings to file
		appendStringsToFile(true);
		
	}
	
	private void createInitialEntry(EObject obj)
	{
		String str = "NamespaceURI = "+obj.eClass().getEPackage().getNsURI(); 
		outputList.add(str);
		
		System.out.println(obj.eClass().getName());
		//System.out.println(manager.getResource().getURIFragment(obj));
	}
	
	private void serialiseAddObjectToResourceE(EObject obj, UUID id) //id can be obtained from object!, change!
	{
		//String str = "CREATE "+obj.eClass().getName()+" "+id.toString();
		
		outputList.add("CREATE "+obj.eClass().getName()+" "+id.toString());
		outputList.add("ADD "+obj.eClass().getName()+" "+id.toString()+" TO RESOURCE");
	}
	
	private void appendStringsToFile(boolean appendMode)
	{
		try
		{
			BufferedWriter bw = new BufferedWriter
				    (new OutputStreamWriter(new FileOutputStream(manager.getURI().path(),appendMode),
				    		Charset.forName(manager.TEXT_ENCODING).newEncoder()));
			PrintWriter out = new PrintWriter(bw);
			for(String string: outputList)
			{
				System.out.println("PersistenceManager.java "+string);
				out.println(string);
			}
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}	
}
