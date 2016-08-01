/**
 * notification.getNotifier().getClass(); should use eclass instead, but how?
 */
package change;


import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EContentAdapter;

import org.eclipse.epsilon.profiling.Stopwatch;

public class EventAdapter extends EContentAdapter
{
	private ChangeLog changeLog;
	private final String RESOURCE_NAME = "DeltaResourceImpl";
	
	public EventAdapter(ChangeLog aChangelog)
	{
		this.changeLog = aChangelog;
	}
	
	
	
	@Override
	public void notifyChanged(Notification msg)
	{
		super.notifyChanged(msg);
		
		
	
		

		if(msg.isTouch())
			return; 
		//System.out.println("EventAdapter: "+msg.getEventType());
		
		//Get the class of the object affected by the change.
	    Class<? extends Object> affectedClass = msg.getNotifier().getClass(); //if we just want a name, get notifer works.
		 
		
	   // Object object = notification.getNotifier();
	    
	   // Object object = notification.getNewValue();
	    
	//	System.out.println("Change made to: "+affectedClass
	//	.getSimpleName());
		
	//	System.out.println("Event type :"+eventType);
		
		
	  // System.out.println("debugging object: "+object.getClass().);
		
	
		switch(msg.getEventType())
		{
		case Notification.ADD :
			if(msg.getNewValue() instanceof EObject) //EObject added to EObject or resource
				handleAddEObjectEvent(msg);
			else if(msg.getFeature() instanceof EAttribute) //Java object, e.g. String added to eattribute of eobject
				handleEAttributeChangeEvent(msg);
			break;
		case Notification.REMOVE:
			EObject obj = (EObject)msg.getOldValue();
			out(obj.eClass().getName()+" was removed from ");
			break;
		case Notification.SET:
			//out("le set happened! ");
			break;
		default:
			//System.out.println("EventAdapater.java default");
			break;
		}
	}
	
	private void handleEAttributeChangeEvent(Notification msg)
	{
		SetAttributeEntry setAttrEntry = new SetAttributeEntry(msg);
		changeLog.addEvent(setAttrEntry); //add to entry
	}
	private void handleRemoveEvent(Notification msg)
	{
		
	}
	private void handleAddEObjectEvent(Notification msg)
	{
		EObject obj = (EObject)msg.getNewValue();
		
		createNewObjectEntry(obj); 
		changeLog.addObjectToMap(obj);
		createSetAttributeEntries (obj);
		
		//If obj is added directly to resource...
		if(msg.getNotifier().getClass().getSimpleName().equals(RESOURCE_NAME)) 
			createAddToResourceEntry(obj);
		else 
			createAddLinkEntry(obj,obj.eContainer(),obj.eContainmentFeature()); 
		
		handleContainments(obj);
	}
	
	
	private void handleContainmentsRecursive(EObject obj) //TBR
	{
		for(EObject o: obj.eContents())//for all the objects containment refs
		{
			//System.out.println(o.eContainingFeature().getName());
			createNewObjectEntry(o);
			
			changeLog.addObjectToMap(o);
			
			createSetAttributeEntries(o);
			
			if(changeLog.getObjectId(obj)== -1) //tbr
				System.out.println("EventAdapter: error !!! adding object to an object which"
						+ " has not yet been created!");
			
			createAddLinkEntry (o,obj,o.eContainmentFeature());
			
			handleContainmentsRecursive(o);
			
	    } 
	}
	
	private void handleContainments(EObject root) 
	{
		//List <EObject> objects = new ArrayList<EObject>();
		
		for(TreeIterator<EObject> it = root.eAllContents(); it.hasNext();)
		{
			EObject obj = it.next();
			createNewObjectEntry(obj);
			changeLog.addObjectToMap(obj);
			createSetAttributeEntries(obj);
			
			if(changeLog.getObjectId(obj.eContainer())== -1) //tbr
				System.out.println("EventAdapter: error !!! adding object to an object which"
						+ " has not yet been created!");
			createAddLinkEntry(obj,obj.eContainer(),obj.eContainmentFeature());
		}
	}
	
	private void createAddLinkEntry(EObject obj, EObject dest, EReference eRef)
	{
		AddLinkEntry entry = new AddLinkEntry(obj,dest,eRef);
		changeLog.addEvent(entry);
	}
	
	private void createAddToResourceEntry(EObject obj)
	{
		AddToResourceEntry entry = new AddToResourceEntry(obj);
		changeLog.addEvent(entry);
	}

	private void createSetAttributeEntries(EObject obj)
	{
		for(EAttribute attr : obj.eClass().getEAllAttributes()) //e vs eall
		{
			if(obj.eIsSet(attr))
			{
				SetAttributeEntry setAttrEntry = new SetAttributeEntry(obj,attr,obj.eGet(attr));
				changeLog.addEvent(setAttrEntry); //add to entry
			}
		}
	}
	
	private void createNewObjectEntry(EObject obj)
	{
		/*Create 'NewObjectEntry' for this object*/
		NewObjectEntry entry = new NewObjectEntry(obj);
		changeLog.addEvent(entry);
	}
	
	private void out(String str)
	{
		System.out.println(this.getClass().getSimpleName()+": "+str);
	}
}
