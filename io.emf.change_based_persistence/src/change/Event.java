package change;

public abstract class Event 
{
	private int eventType;
	
	public static final int SET_EATTRIBUTE_SINGLE = 1;
	public static final int SET_EATTRIBUTE_MANY = 2;
	public static final int SET_EREFERENCE_SINGLE = 3;
	public static final int SET_EREFERENCE_MANY = 4;
	public static final int UNSET_EATTRIBUTE_SINGLE = 5;
	public static final int UNSET_EATTRIBUTE_MANY = 6;
	public static final int UNSET_EREFERENCE_SINGLE = 7;
	public static final int UNSET_EREFERENCE_MANY = 8;

	public Event(int eventType)
	{
		this.eventType = eventType;
	}
	
	public int getType()
	{
		return eventType;
	}
}
