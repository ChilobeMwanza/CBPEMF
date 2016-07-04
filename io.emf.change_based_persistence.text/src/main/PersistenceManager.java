
//http://www.javapractices.com/topic/TopicAction.do?Id=31
package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import io.emf.cbp.text.change.AbstractEntry;
import io.emf.cbp.text.change.ChangeLog;
import io.emf.cbp.text.change.Entry;

public class PersistenceManager 
{
	private ChangeLog changeLog;
	private String fileSaveLocation;
	
	
	public PersistenceManager(Map<?,?> options, ChangeLog aChangeLog)
	{
		changeLog = aChangeLog;
		fileSaveLocation = (String) options.get("FILE_SAVE_LOCATION");
	}
	
	public void save()
	{
		
		try
		{
			FileWriter fw = new FileWriter(fileSaveLocation,true); //allows us to append to file
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter out = new PrintWriter(bw);
			
			for(AbstractEntry entry: changeLog.getEventsList())
			{
				for(String string: entry.getOutputStringsArray())
				{
					System.out.println(string);
					out.println(string);
				}
			}
			out.close();
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		//System.out.println("Size of events list: "+changeLog.getEventsList().size());
		
		
	//	out.close();
	}
}
