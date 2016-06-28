package io.emf.cbp.text.change;

import java.util.ArrayList;
import java.util.List;

public enum ChangeLog 
{
	//public static final ChangeLog INSTANCE = new ChangeLog();
	INSTANCE;
	
	private List<Entry> eventsList = new ArrayList<Entry>();
	
	public void addEvent(Entry event)
	{
		eventsList.add(event);
	}
	
	public List<Entry> getEventsList()
	{
		return eventsList;
	}
	
	
}
