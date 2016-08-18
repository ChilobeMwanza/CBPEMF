package change;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import impl.DeltaResourceImpl;

public class SetEReferenceManyEvent extends Event 
{
	private NotifierType type;
	
	private List<EObject> obj_list;
	private EObject focus_obj;
	private EReference eref;
	
	public SetEReferenceManyEvent(List<EObject> obj_list, NotifierType type)
	{
		super(Event.SET_EREFERENCE_MANY);
		
		this.obj_list = obj_list;
		this.type = type;
	}
	
	public SetEReferenceManyEvent(EObject focus_obj,List<EObject> obj_list,EReference eref, NotifierType type)
	{
		super(Event.SET_EREFERENCE_MANY);
		
		this.focus_obj = focus_obj;
		this.obj_list = obj_list;
		this.type = type;
		this.eref = eref;
	}
	
	
	@SuppressWarnings("unchecked")
	public SetEReferenceManyEvent(Notification n)
	{
		super(Event.SET_EREFERENCE_MANY);
		
		this.obj_list = (List<EObject>) n.getNewValue();
		
		 if(n.getNotifier() instanceof DeltaResourceImpl)
		 {
			 this.type = NotifierType.RESOURCE;
		 }
		 else if(n.getNotifier() instanceof EObject)
		 {
			 this.type = NotifierType.EOBJECT;
			 this.focus_obj = (EObject) n.getNotifier();
			 this.eref = (EReference) n.getFeature();
		 } 
	}
	
	public NotifierType getNotifierType()
	{
		return this.type;
	}
	
	public EObject getFocusObj()
	{
		return focus_obj;
	}
	
	public List<EObject> getEObjectList()
	{
		return this.obj_list;
	}
	
	public EReference getEReference()
	{
		return this.eref;
	}
}