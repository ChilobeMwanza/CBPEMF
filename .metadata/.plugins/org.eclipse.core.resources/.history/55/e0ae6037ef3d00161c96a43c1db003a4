
//http://www.javapractices.com/topic/TopicAction.do?Id=31
package main;

import io.emf.cbp.text.change.ChangeLog;
import io.emf.cbp.text.change.Entry;
import io.emf.cbp.text.change.InitialEntry;

public class PersistenceManager 
{
	private ChangeLog changeLog;
	
	public PersistenceManager(ChangeLog aChangeLog)
	{
		changeLog = aChangeLog;
	}
	
	public void save()
	{
		for(Entry entry: changeLog.getEventsList() )
		{
			if(entry instanceof InitialEntry) //fix this whole 'instance of' thing.
			{
				System.out.println("Initial entry!");
			}
			
		}
	}
}
