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
	    Class<? extends Object> affectedClass = notification.getNotifier().getClass();
	    int eventType = notification.getEventType();
	    Object object = notification.getNotifier();
	    
	/*	System.out.println("Change made to: "+affectedClass
		.getSimpleName());
		
		System.out.println("Event type :"+eventType);*/
	}
}
