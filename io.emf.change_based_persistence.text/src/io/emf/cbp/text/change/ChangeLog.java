package io.emf.cbp.text.change;

import java.util.ArrayList;
import java.util.List;

public class ChangeLog 
{
	//public static final ChangeLog INSTANCE = new ChangeLog();
	
	
	private List<AbstractEntry> eventsList = new ArrayList<AbstractEntry>();
	
	public void addEvent(AbstractEntry entry)
	{
		eventsList.add(entry);
	}
	
	public List<AbstractEntry> getEventsList()
	{
		return eventsList;
	}
	
	
}
