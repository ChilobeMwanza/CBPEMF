package change;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import impl.DeltaResourceImpl;

public class SetEReferenceSingleEvent extends Event
{
	private enum NotifierType
	{
		EOBJECT,
		RESOURCE;
	}
	
	private EObject added_obj;
	private EObject focus_obj;
	private NotifierType type;
	
	public SetEReferenceSingleEvent(EObject added_obj,NotifierType type)
	{
		super(Event.SET_EREFERENCE_SINGLE);
		
		this.added_obj = added_obj;
		this.type = type;
	}
	
	public SetEReferenceSingleEvent(EObject added_obj, EObject focus_obj,NotifierType type)
	{
		super(Event.SET_EREFERENCE_SINGLE);
		
		this.added_obj = added_obj;
		this.focus_obj = focus_obj;
		this.type = type;
	}
	
	public SetEReferenceSingleEvent(Notification n)
	{
		super(Event.SET_EREFERENCE_SINGLE);
		
		this.added_obj = (EObject)n.getNewValue();
		
		if(n.getNotifier() instanceof DeltaResourceImpl)
		{
			this.type = NotifierType.RESOURCE;
		}
		else if(n.getNotifier() instanceof EObject)
		{
			this.type = NotifierType.RESOURCE;
			this.focus_obj = (EObject) n.getNotifier();
		}	
	}
	
	public EObject getAddedObject()
	{
		return this.added_obj;
	}
	
	public EObject getFocusObject()
	{
		return this.focus_obj;
	}
	
	public NotifierType getNotifierType()
	{
		return this.type;
	}
	
}
