package drivers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.resource.Resource;

import change.AddEObjectsToEReferenceEvent;
import change.AddEObjectsToResourceEvent;
import change.AddObjectsToEAttributeEvent;
import change.Changelog;

public class ResourceContentsToEventsConverter 
{
	Changelog changelog;
	Resource resource;
	
	@SuppressWarnings("unused")
	private  final String classname = this.getClass().getSimpleName();
	
	public ResourceContentsToEventsConverter(Changelog changelog, Resource resource)
	{
		this.changelog = changelog;
		this.resource = resource;
	}
	
	public void convert()
	{
		if(resource.getContents().isEmpty())
			return;
		
		changelog.clear();
		
		AddEObjectsToResourceEvent e = new AddEObjectsToResourceEvent (resource.getContents());
		changelog.addEvent(e);
		
		for(EObject obj : resource.getContents())
		{
			createSetAttributeEntries(obj);
			handleReferences(obj);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	private void handleReferences(EObject root) 
	{
		for(Iterator<EObject> it = root.eAllContents(); it.hasNext();) //containment refs
		{
			EObject obj = it.next();
			
			createAddEObjectsToEReferenceEvent(obj.eContainer(),obj,obj.eContainmentFeature());
		
			createSetAttributeEntries(obj);
		}
		
		for(EReference rf : root.eClass().getEAllReferences())//non containment refs
		{
			if(!rf.isContainment())
			{
				if(root.eIsSet(rf))
				{
				   createAddEObjectsToEReferenceEvent(root,root.eGet(rf),rf);
				   createSetAttributeEntries(root.eGet(rf));
				   
				   //handle  containments of eObjects within root.eGet
				   List <EObject> children = new ArrayList<EObject>();
				   
				   if(root.eGet(rf) instanceof Collection)
				   {
					   children = (List<EObject>) root.eGet(rf);
				   }
				   else
				   {
					   children.add((EObject)root.eGet(rf));
				   }
				   
				   for(EObject obj : children)
				   {
					   /*
					    * For opposite references, we try to always pick the same ref. We don't want to recurse 
					    * for both ends of the ref. Choose ref by comparing name lengths 
					    */
					   if(rf.getEOpposite() != null)
					   {
						   //choose based on feature id.
						   if((rf.getContainerClass().getName().length()+rf.getName().length()) > 
						   			(rf.getEOpposite().getContainerClass().getName().length()
						   					+rf.getEOpposite().getName().length()))	   
						   { 
							   if(rf.getFeatureID() > rf.getEOpposite().getFeatureID())
							   {
								   handleReferences(obj);  
							   }
						   }					   
					   }
					   else //for non opposites
					   {
						   handleReferences(obj);
					   }
				   }
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void createAddEObjectsToEReferenceEvent
		(EObject focusObject,Object value, EReference eRef)
	{
		List<EObject> eObjectList = new ArrayList<EObject>();
		
		if(value instanceof Collection)
		{
			 eObjectList = (List<EObject>) value;
		}
		else
		{
			eObjectList.add((EObject) value);
		}
		
		for(EObject obj : eObjectList)
		{
			AddEObjectsToEReferenceEvent e = 
					new AddEObjectsToEReferenceEvent(focusObject,obj,eRef);
			changelog.addEvent(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void createSetAttributeEntries(Object value)
	{
		List<EObject> eObjectList = new ArrayList<EObject>();
		
		if(value instanceof Collection)
		{
			 eObjectList = (List<EObject>) value;
		}
		else
		{
			eObjectList.add((EObject) value);
		}
		
		for(EObject obj : eObjectList)
		{
			for(EAttribute attr : obj.eClass().getEAllAttributes())
			{
				if(obj.eIsSet(attr) && attr.isChangeable() && 
						!attr.isTransient() && !attr.isVolatile())
				{
					AddObjectsToEAttributeEvent e =
							new AddObjectsToEAttributeEvent(obj,attr,obj.eGet(attr));
					changelog.addEvent(e); //add to entry
				}
			}
		}
		
	}
}
