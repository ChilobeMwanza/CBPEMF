package change;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import impl.CBPTextResourceImpl;

public class UnsetEReferenceSingleEvent extends Event 
{
	private EObject focus_obj;
	private EObject removed_obj;
	private EReference eref;
	private NotifierType type;

	public UnsetEReferenceSingleEvent(EObject focus_obj,EObject removed_obj,EReference eref, NotifierType type)
	{
		super(Event.UNSET_EREFERENCE_SINGLE);
		
		this.focus_obj = focus_obj;
		this.removed_obj = removed_obj;
		this.type = type;
		this.eref = eref;
		
	}
	
	public UnsetEReferenceSingleEvent(EObject removed_obj,NotifierType type)
	{
		super(Event.UNSET_EREFERENCE_SINGLE);
		
		this.removed_obj = removed_obj;
		this.type = type;
	}
	
	public UnsetEReferenceSingleEvent(Notification n)
	{
		super(Event.UNSET_EREFERENCE_SINGLE);
		
		this.removed_obj = (EObject)n.getOldValue();
		
		if(n.getNotifier() instanceof CBPTextResourceImpl)
			this.type = NotifierType.RESOURCE;
		
		else if(n.getNotifier() instanceof EObject)
		{
			this.type = NotifierType.EOBJECT;
			this.focus_obj = (EObject) n.getNotifier();
			this.eref = (EReference) n.getFeature();
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
	
	public EReference getEReference()
	{
		return this.eref;
	}
}
