package main;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;

public class EventAdapter extends EContentAdapter
{
	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification);
		
		if(notification.isTouch())
			return; 
		
		//Get the class of the object affected by the change.
	    Class<? extends Object> affectedObject = notification.getNotifier().getClass();
	    int eventType = notification.getEventType();
	    
		System.out.println("Change made to: "+affectedObject
		.getSimpleName());
		
		System.out.println("Event type :"+eventType);
	}
}
