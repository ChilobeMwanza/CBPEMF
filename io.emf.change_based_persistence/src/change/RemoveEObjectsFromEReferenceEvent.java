package change;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class RemoveEObjectsFromEReferenceEvent extends EReferenceEvent
{
	/*EObject added to another EObject via some EReference*/
	public RemoveEObjectsFromEReferenceEvent(EObject focusObject,Object oldValue,EReference eReference)
    {
        super(Event.REMOVE_EOBJECTS_FROM_EREFERENCE_EVENT, focusObject, eReference, oldValue);
    }
	
    public RemoveEObjectsFromEReferenceEvent(Notification n)
    {
       super(Event.REMOVE_EOBJECTS_FROM_EREFERENCE_EVENT,n);
    } 
}


