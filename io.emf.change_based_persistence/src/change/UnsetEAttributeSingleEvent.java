package change;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class UnsetEAttributeSingleEvent extends Event
{
	private EObject focus_obj;
	private EAttribute attr;
	private Object old_value;
	
	public UnsetEAttributeSingleEvent(EObject focus_obj, EAttribute attr, Object old_value)
	{
		super(Event.UNSET_EATTRIBUTE_SINGLE);
		
		this.focus_obj = focus_obj;
		this.attr = attr;
		this.old_value = old_value;
	}
	
	public UnsetEAttributeSingleEvent(Notification n)
	{
		this((EObject) n.getNotifier(),(EAttribute) n.getFeature(),n.getOldValue());
	}
	
	public EObject getFocusObject()
	{
		return this.focus_obj;
	}
	
	public EAttribute getEAttribute()
	{
		return this.attr;
	}
	
	public Object getOldValue()
	{
		return this.old_value;
	}
}