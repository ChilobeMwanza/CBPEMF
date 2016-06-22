package main;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

import library.Library;

public class ChangeAdapter extends AdapterImpl 
{
	@Override
	public void notifyChanged(Notification notification)
	{
		//if(notification.getNotifier() instanceof x)
		if(notification.isTouch())
		{
			System.out.println("Touch event, nothing changed");
		}
		
		System.out.println("Change made to : "+notification.getNotifier().getClass().getSimpleName());
		System.out.println("Event type: "+notification.getEventType());
		

		/*if(notification.getNotifier() instanceof Library)
		{
			System.out.println("Change was made to library!");
			
			System.out.println(notification.getEventType());
			
		}*/
		
		
	
		
	}
	
	/**
	 * Used by adapter factories when checking if an adapter of a specified type is already attached to an object.
	 */
	@Override
	public boolean isAdapterForType(Object type)
	{
		return type == ChangeAdapter.class;
	}
}
