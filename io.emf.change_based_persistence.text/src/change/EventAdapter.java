/**
 * notification.getNotifier().getClass(); should use eclass instead, but how?
 */
package change;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EContentsEList;

public class EventAdapter extends EContentAdapter
{
	private ChangeLog changelog;
	private final String RESOURCE_NAME = "DeltaResourceImpl";
	private  final String classname = this.getClass().getSimpleName();
	
	private boolean adapterEnabled = true;
	
	public EventAdapter(ChangeLog aChangelog)
	{
		super(); 
		this.changelog = aChangelog;
	}
	
	@Override
	public void notifyChanged(Notification n)
	{
		super.notifyChanged(n);
		
		if(n.isTouch() || !adapterEnabled)
			return;
		
		switch(n.getEventType())
		{
			case Notification.ADD :
			{
				changelog.addNotification(n);
				break;		
			}
			case Notification.ADD_MANY : 
			{
				changelog.addNotification(n);
				break;
			}
			case Notification.REMOVE:
			{
				//changelog.addNotification(n);
				break;
			}
			case Notification.SET:
			{
				if(n.getFeature() instanceof EAttribute || n.getNewValue() instanceof EObject)
				{
					changelog.addNotification(n);
				}
				break;
			}
			case Notification.UNSET: //tbr
			{
				if(n.getFeature() instanceof EAttribute || n.getNewValue() instanceof EObject)
				{
					//changeLog.addNotification(n);
					System.out.println(classname+" UNSET!");
				}
				System.out.println(classname+"unset happens still");
				break;
			}
				
			default:
				//System.out.println("EventAdapater.java default");
				break;
		}
	}
	
	public void setEnabled(boolean bool)
	{
		adapterEnabled = bool;
	}
	
	
	/* The following code (which allows subclass EContentAdapter to receive notifications across non containment 
	 * references was copied verbatim from : http://wiki.eclipse.org/EMF/Recipes#Recipe:_Subclass_EContentAdapter
	 * _to_receive_notifications_across_non-containment_references*/
	
	
	/**
     * By default, all cross document references are followed. Usually this is
     * not a great idea so this class can be subclassed to customize.
     * 
     * @param feature
     *      a cross document reference
     * @return whether the adapter should follow it
     */
    protected boolean shouldAdapt(EStructuralFeature feature)
    {
        return true;
    }
    
    @Override
    protected void setTarget(EObject target)
    {
        super.setTarget(target);
        for (EContentsEList.FeatureIterator<EObject> featureIterator = (EContentsEList.FeatureIterator<EObject>) target.eCrossReferences()
                                                                                                                       .iterator(); featureIterator.hasNext();)
        {
            Notifier notifier = featureIterator.next();
            EStructuralFeature feature = featureIterator.feature();
            if (shouldAdapt(feature))
            {
                addAdapter(notifier);
            }
        }
    }
	
    @Override
    protected void unsetTarget(EObject target)
    {
        super.unsetTarget(target);
        for (EContentsEList.FeatureIterator<EObject> featureIterator = (EContentsEList.FeatureIterator<EObject>) target.eCrossReferences()
                                                                                                                       .iterator(); featureIterator.hasNext();)
        {
            Notifier notifier = featureIterator.next();
            EStructuralFeature feature = featureIterator.feature();
            if (shouldAdapt(feature))
            {
                removeAdapter(notifier);
            }
        }
    }
    
    @Override
    protected void selfAdapt(Notification notification)
    {
        super.selfAdapt(notification);
        if (notification.getNotifier() instanceof EObject)
        {
            Object feature = notification.getFeature();
            if (feature instanceof EReference)
            {
                EReference eReference = (EReference) feature;
                if (!eReference.isContainment() && shouldAdapt(eReference))
                {
                    handleContainment(notification);
                }
            }
        }
    }
}