package change;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import impl.DeltaResourceImpl;

public class UnsetEReferenceManyEvent extends Event 
{
	private enum NotifierType
	{
		EOBJECT,
		RESOURCE;
	}
	
	private NotifierType type;
	
	private List<EObject> obj_list;
	private EObject focus_obj;
	
	public UnsetEReferenceManyEvent(List<EObject> obj_list, NotifierType type)
	{
		super(Event.UNSET_EREFERENCE_MANY);
		
		this.obj_list = obj_list;
		this.type = type;
	}
	
	public UnsetEReferenceManyEvent(List<EObject> obj_list, EObject focus_obj, NotifierType type)
	{
		super(Event.UNSET_EREFERENCE_MANY);
		
		this.obj_list = obj_list;
		this.focus_obj = focus_obj;
		this.type = type;
	}
	
	@SuppressWarnings("unchecked")
	public UnsetEReferenceManyEvent(Notification n)
	{
		super(Event.UNSET_EREFERENCE_MANY);
		
		this.obj_list = (List<EObject>) n.getNewValue();
		
		if(n.getNotifier() instanceof DeltaResourceImpl)
		{
			this.type = NotifierType.RESOURCE;
		}
		else if(n.getNotifier() instanceof EObject)
		{
			this.type = NotifierType.EOBJECT;
			this.focus_obj = (EObject) n.getNotifier();
		}	
	}
	
	public List<EObject> getObjectList()
	{
		return this.obj_list;
	}
	
	public EObject getFocusObj()
	{
		return this.focus_obj;
	}
	
	public NotifierType getNotiferType()
	{
		return this.type;
	}
}
