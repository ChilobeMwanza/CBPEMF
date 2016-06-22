package main;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;



public class AnotherAdapter extends EContentAdapter
{
	@Override
	public void notifyChanged(Notification notification)
	{
		super.notifyChanged(notification); //must call, enables ECAdapter to attach and remove adapters as contents are added or remov
		//if(notification.getNotifier() instanceof x)
		if(notification.isTouch())
		{
			System.out.println("Touch event, nothing changed");
		}
		
		
		
		System.out.println("Change made to : "+notification.getNotifier().getClass().getSimpleName());
		System.out.println("Event type: "+notification.getEventType());
	    //System.out.println(notification.getFeatureID(XMIResourceImpl.class));
	    
	    
	    Object feature = notification.getFeature();
	    System.out.println(feature);
		

		/*if(notification.getNotifier() instanceof Library)
		{
			System.out.println("Change was made to library!");
			
			System.out.println(notification.getEventType());
			
		}*/
		
		
	
		
	}
}
