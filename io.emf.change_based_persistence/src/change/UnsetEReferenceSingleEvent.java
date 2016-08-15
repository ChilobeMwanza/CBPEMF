package change;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import impl.DeltaResourceImpl;

public class UnsetEReferenceSingleEvent extends Event 
{
	private enum NotifierType
	{
		EOBJECT,
		RESOURCE;
	}
	
	private EObject focus_obj;
	private EObject removed_obj;
	private NotifierType type;

	private UnsetEReferenceSingleEvent(EObject focus_obj,EObject removed_obj,NotifierType type)
	{
		super(Event.UNSET_EREFERENCE_SINGLE);
		
		this.focus_obj = focus_obj;
		this.removed_obj = removed_obj;
		this.type = type;
	}
	
	private UnsetEReferenceSingleEvent(EObject removed_obj,NotifierType type)
	{
		super(Event.UNSET_EREFERENCE_SINGLE);
		
		this.removed_obj = removed_obj;
		this.type = type;
	}
	
	private UnsetEReferenceSingleEvent(Notification n)
	{
		super(Event.UNSET_EREFERENCE_SINGLE);
		
		this.removed_obj = (EObject)n.getOldValue();
		
		if(n.getNotifier() instanceof DeltaResourceImpl)
			this.type = NotifierType.RESOURCE;
		
		else if(n.getNotifier() instanceof EObject)
		{
			this.type = NotifierType.EOBJECT;
			this.focus_obj = (EObject) n.getNotifier();
		}
			
	}
	
	public EObject getFocusObject()
	{
		return this.focus_obj;
	}
	
	public EObject getRemovedObject()
	{
		return this.removed_obj;
	}
	
	public NotifierType getNotifierType()
	{
		return this.type;
	}
}
