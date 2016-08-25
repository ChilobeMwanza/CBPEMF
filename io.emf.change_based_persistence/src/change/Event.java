package change;

public abstract class Event 
{
	private int eventType;

	public static final int SET_EATTRIBUTE_EVENT = 0;
	public static final int SET_EREFERENCE_EVENT = 1;
	public static final int UNSET_EREFERENCE_EVENT = 2;
	public static final int UNSET_EATTRIBUTE_EVENT = 3;
	public static final int ADD_EOBJECTS_TO_RESOURCE_EVENT = 4;
	public static final int REMOVE_EOBJECTS_FROM_RESOURCE_EVENT = 5;

	public Event(int eventType)
	{
		this.eventType = eventType;
	}
	
	public int getEventType()
	{
		return eventType;
	}
}
