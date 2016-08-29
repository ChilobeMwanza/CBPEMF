package change;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

public class AddEObjectsToEReferenceEvent extends EReferenceEvent
{
	public AddEObjectsToEReferenceEvent(EObject focusObject,Object newValue,EReference eReference)
    {
        super(Event.ADD_EOBJECTS_TO_EREFERENCE_EVENT, focusObject,eReference,newValue);
    }
	
    public AddEObjectsToEReferenceEvent(Notification n)
    {
       super(Event.ADD_EOBJECTS_TO_EREFERENCE_EVENT,n);
    } 
}


