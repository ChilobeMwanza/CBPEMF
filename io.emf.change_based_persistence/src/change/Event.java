package change;

public abstract class Event 
{
	public static enum NotifierType
	{
		EOBJECT,
		RESOURCE;
	}
	
	private int event_type;
	
	public static final int SET_EATTRIBUTE_SINGLE = 1;
	public static final int SET_EATTRIBUTE_MANY = 2;
	public static final int SET_EREFERENCE_SINGLE = 3;
	public static final int SET_EREFERENCE_MANY = 4;
	public static final int UNSET_EATTRIBUTE_SINGLE = 5;
	public static final int UNSET_EATTRIBUTE_MANY = 6;
	public static final int UNSET_EREFERENCE_SINGLE = 7;
	public static final int UNSET_EREFERENCE_MANY = 8;

	public Event(int event_type)
	{
		this.event_type = event_type;
	}
	
	public int getEventType()
	{
		return event_type;
	}
}
