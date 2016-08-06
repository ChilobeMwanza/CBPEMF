/*
 * todo:
 * DIFF BETWEEN SET AND ADD IS ARTIFICIAL!
 * deletion
 * opposite ref
 * enums
 * escape delimiter
 * resume after load (as in pick up where you left off)
 * thoroughness (i.e of supported types e.t.c, start with enum)
 * optimisation algorithm
 * check everything works with non generated emf (Reflective)
 * make txt format less verbose
 * binary
 * 
 * List of known unsupported features:
 * derived attributes
 */
package drivers;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import change.ChangeLog;

import util.Printer;

public class TextSerializer 
{
	private final String RESOURCE_NAME = "DeltaResourceImpl";
	private  final String classname = this.getClass().getSimpleName();
	private final PersistenceManager manager;
	private boolean appendMode = false;
	private List<String> outputList;
    private List<Notification> notificationsList;
    Printer out = new Printer (this.getClass());
	private final ChangeLog changelog; 
	
	public TextSerializer(PersistenceManager manager, ChangeLog aChangeLog)
	{
		this.manager =  manager;
		this.changelog = aChangeLog;
		this.outputList = new ArrayList<String>();
		this.notificationsList = new ArrayList<Notification>();
		
		notificationsList = manager.getChangeLog().getEventsList();
	}
	
	public void save(Map<?,?> options)
	{
		if(notificationsList.isEmpty())
			return;
		
		if(!appendMode)
			serialiseInitialEntry();
		
		//String fileSaveLocation = (String) options.get("FILE_SAVE_LOCATION");
		
		for(Notification n : notificationsList)
		{
			switch(n.getEventType())
			{
				case Notification.ADD:
				{
					if(n.getNewValue() instanceof EObject) 
						handleSetEReferenceSingleEvent(n);
					else if(n.getFeature() instanceof EAttribute)
						handleSetEAttributeSingleEvent(n);
					
					break;
				}
				case Notification.SET:
				{
					if(n.getNewValue() instanceof EObject)
						handleSetEReferenceSingleEvent(n);
					
					else if(n.getFeature() instanceof EAttribute)
						handleSetEAttributeSingleEvent(n);
					
					else if(n.getNewValue() == null)
						handleUnsetEReferenceSingleEvent(n);
					break;
				}
				case Notification.ADD_MANY:
				{
					@SuppressWarnings("unchecked")
					List<Object> list =  (List<Object>) n.getNewValue();
					if(list.get(0) instanceof EObject)
						handleAddManyEObjectsEvent(n);
					
					else if(n.getFeature() instanceof EAttribute)
						handleSetEAttributeManyEvent(n);
					
					break;
				}
				case Notification.REMOVE:
				{
					if(n.getOldValue() instanceof EObject)
						handleUnsetEReferenceSingleEvent(n);
					else if(n.getFeature() instanceof EAttribute)
						 handleUnsetEAttributeSingleEvent(n);
					break;
				}
				case Notification.REMOVE_MANY:
				{
					break;
				}
				default:
				{
					System.out.println(classname+"Unhandled notification!");
				}
			}
		}
		
		//finally append strings to file
		appendStringsToFile(appendMode);
	}
	
	private void handleSetEAttributeSingleEvent(Notification n)
	{
		EObject focus_obj = (EObject) n.getNotifier();
		
		EAttribute attr = (EAttribute) n.getFeature();
		
		String newValue = EcoreUtil.convertToString(attr.getEAttributeType(),  n.getNewValue());
		
		outputList.add("SET_A "+attr.getName()+" "+focus_obj.eClass().getName()+" "+changelog.getObjectId(focus_obj)+" ["+newValue+"]");
	}
	
	private void handleUnsetEAttributeSingleEvent(Notification n)
	{
		EObject focus_obj = (EObject) n.getNotifier();
		EAttribute attr = (EAttribute) n.getFeature();
		
		String oldValue = EcoreUtil.convertToString(attr.getEAttributeType(),  n.getOldValue());
		
		outputList.add("UNSET_A "+attr.getName()+" "+focus_obj.eClass().getName()+" "
					+changelog.getObjectId(focus_obj)+" ["+oldValue+"]");
	}
	
	private void handleSetEAttributeManyEvent(Notification n)
	{
		EObject focus_obj = (EObject) n.getNotifier();
		EAttribute attr = (EAttribute) n.getFeature();
		
		@SuppressWarnings("unchecked")
		List<Object> attr_values_list = (List<Object>) n.getNewValue();
		
		
		String obj_list_str = "[";
		
		for(Object object: attr_values_list)
		{
			String newValue = (EcoreUtil.convertToString(attr.getEAttributeType(), object));
			obj_list_str = obj_list_str + newValue+",";
		}
		obj_list_str = obj_list_str.substring(0,obj_list_str.length()-1)+"]"; // remove final "," , add "]"
		outputList.add("SET_A "+attr.getName()+" "+focus_obj.eClass().getName()+" "+changelog.getObjectId(focus_obj)+" "+obj_list_str);
	}
	
	private void handleUnsetEAttributeManyEvent(Notification n)
	{
		//TO DO
	}
	
	private void handleSetEReferenceSingleEvent(Notification n)
	{
		EObject added_obj = (EObject)n.getNewValue();
		
		if(changelog.addObjectToMap(added_obj))//make 'create' entries for obj which don't already exist
			outputList.add("CREATE ["+added_obj.eClass().getName()+ " "+changelog.getObjectId(added_obj)+"]");
			
		if(n.getNotifier().getClass().getSimpleName().equals(RESOURCE_NAME)) //add eobject to resource
		{
			outputList.add("ADD_R ["+added_obj.eClass().getName()+" "+changelog.getObjectId(added_obj)+"]"); 
		}
		else //add eobject to eobject
		{
			EObject focus_obj = (EObject) n.getNotifier();
			outputList.add("SET_R "+((EReference)n.getFeature()).getName()+" "+focus_obj.eClass().getName()+" "
					+changelog.getObjectId(focus_obj)+" ["+added_obj.eClass().getName()+" "
					+changelog.getObjectId(added_obj)+"]");
		}
	}
	
	private void handleUnsetEReferenceSingleEvent(Notification n)
	{
		EObject removed_obj = (EObject)n.getOldValue();
		
		if(n.getNotifier().getClass().getSimpleName().equals(RESOURCE_NAME)) //delete eobject from resource
		{
			outputList.add("DEL_R ["+removed_obj.eClass().getName()+" "+
					changelog.getObjectId(removed_obj)+"]"); 
		}
		else
		{
			EObject focus_obj = (EObject) n.getNotifier();
			outputList.add("UNSET_R "+((EReference)n.getFeature()).getName()+" "+focus_obj.eClass().getName()+" "
					+changelog.getObjectId(focus_obj)+" ["+removed_obj.eClass().getName()+" "
					+changelog.getObjectId(removed_obj)+"]");
		}
	}
	
	private void handleSetEReferenceManyEvent(Notification n)
	{
		List<EObject> obj_list = (List<EObject>) n.getNewValue();
		
		String added_obj_list_str = "["; //list of obj to add
		String obj_create_list_str = "["; //list of obj to create

		
		for(EObject obj : obj_list)
		{
			if(changelog.addObjectToMap(obj)) //if obj does not already exist
			{
				obj_create_list_str = obj_create_list_str + obj.eClass().getName()+" "
						+ ""+changelog.getObjectId(obj)+","; 
			}
			
			added_obj_list_str = added_obj_list_str + obj.eClass().getName()+" "+changelog.getObjectId(obj)+","; 
		}
		
		if(obj_create_list_str.length()>1) //if we have items to create...
		{
			 obj_create_list_str = obj_create_list_str.substring(0,added_obj_list_str.length()-1)+"]"; // remove final "," , add "]"
			 outputList.add("CREATE "+ obj_create_list_str);
		}
		
	    added_obj_list_str = added_obj_list_str.substring(0,added_obj_list_str.length()-1)+"]"; // remove final "," , add "]"
	    
	    if(n.getNotifier().getClass().getSimpleName().equals(RESOURCE_NAME)) //add eobject to resource
	    {
	    	outputList.add("ADD_R "+added_obj_list_str);
	    }	
	    else //add eobject to eobject
	    {
	    	EObject focus_obj = (EObject) n.getNotifier();
	    	
	    	outputList.add("SET_R "+((EReference)n.getFeature()).getName()+" "+focus_obj.eClass().getName()+" "
					+changelog.getObjectId(focus_obj)+" "+added_obj_list_str);
	    }
	}
	

	
	private void serialiseInitialEntry()
	{
		EObject obj = null;
		for(Notification n : notificationsList)
		{
			if(n.getEventType() == Notification.ADD)
			{
				obj = (EObject) n.getNewValue();
				break;
			}
			else if(n.getEventType() == Notification.ADD_MANY)
			{
				List<EObject> objectsList = (List<EObject>) n.getNewValue();
				obj = objectsList.get(0);
				break;
			}
		}
		outputList.add("NAMESPACE_URI "+obj.eClass().getEPackage().getNsURI());
	}
	

	
	private void appendStringsToFile(boolean appendMode)
	{
		try
		{
			BufferedWriter bw = new BufferedWriter
				    (new OutputStreamWriter(new FileOutputStream(manager.getURI().path(),appendMode),
				    		Charset.forName(manager.TEXT_ENCODING).newEncoder()));
			PrintWriter out = new PrintWriter(bw);
			for(String string: outputList)
			{
				//System.out.println("PersistenceManager.java "+string);
				out.println(string);
			}
			out.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}	
}
