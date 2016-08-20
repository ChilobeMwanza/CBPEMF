/*
 * todo:
 * make txt format less verbose
 * when unsetting single valued feature, name is not needed
 * binary
 * change log optimisation
 * more tests
 * 
 */
package drivers;


import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.profiling.Stopwatch;

import change.Changelog;
import change.Event;
import change.SetEAttributeManyEvent;
import change.SetEAttributeSingleEvent;
import change.SetEReferenceManyEvent;
import change.SetEReferenceSingleEvent;
import change.UnsetEAttributeManyEvent;
import change.UnsetEAttributeSingleEvent;
import change.UnsetEReferenceManyEvent;
import change.UnsetEReferenceSingleEvent;


public class TextSerializer 
{
	private  final String classname = this.getClass().getSimpleName();
	
	private final String FORMAT_ID = "CBP_TEXT"; 
	
	private final double VERSION = 1.0;
	
    private final List<Event> eventList;
    
	private final PersistenceManager manager;
	
	private final Changelog changelog; 
	
	private final EPackageElementsNamesMap ePackageElementsNamesMap;
	
	private PrintWriter printWriter;
	
	public TextSerializer(PersistenceManager manager, Changelog aChangelog, EPackageElementsNamesMap 
			ePackageElementsNamesMap)
	{
		this.manager =  manager;
		this.changelog = aChangelog;
		this.ePackageElementsNamesMap = ePackageElementsNamesMap;
		
		this.eventList = manager.getChangelog().getEventsList();
	}
	
	public void save(Map<?,?> options)
	{
		if(eventList.isEmpty())
			return;
		
		//setup printwriter
	    try
        {
	    	BufferedWriter bw = new BufferedWriter
                    (new OutputStreamWriter(new FileOutputStream(manager.getURI().path(),manager.isResume()),
                            Charset.forName(PersistenceManager.TEXT_ENCODING).newEncoder()));
            printWriter = new PrintWriter(bw);
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
		
		
		//if we're not in resume mode, serialise initial entry
		if(!manager.isResume())
			serialiseInitialEntry();
		
		for(Event e : eventList)
		{
			switch(e.getEventType())
			{
			case Event.SET_EATTRIBUTE_SINGLE:
				handleSetEAttributeSingleEvent((SetEAttributeSingleEvent)e);
				break;
			case Event.SET_EATTRIBUTE_MANY:
				handleSetEAttributeManyEvent((SetEAttributeManyEvent)e);
				break;
			case Event.SET_EREFERENCE_SINGLE:
				handleSetEReferenceSingleEvent((SetEReferenceSingleEvent)e);
				break;
			case Event.SET_EREFERENCE_MANY:
				handleSetEReferenceManyEvent((SetEReferenceManyEvent)e);
				break;
			case Event.UNSET_EATTRIBUTE_SINGLE:
				handleUnsetEAttributeSingleEvent((UnsetEAttributeSingleEvent)e);
				break;
			case Event.UNSET_EATTRIBUTE_MANY:
				handleUnsetEAttributeManyEvent((UnsetEAttributeManyEvent)e);
				break;
			case Event.UNSET_EREFERENCE_SINGLE:
				handleUnsetEReferenceSingleEvent((UnsetEReferenceSingleEvent)e);
				break;
			case Event.UNSET_EREFERENCE_MANY:
				handleUnsetEReferenceManyEvent((UnsetEReferenceManyEvent)e);
				break;
			}
		}
		
		changelog.clearEvents();
		
		printWriter.close();
		manager.setResume(true);
	}
	
	private void handleSetEAttributeSingleEvent(SetEAttributeSingleEvent e)
	{
		EObject focus_obj = e.getFocusObj();
		
		EAttribute attr = e.getEAttribte();
		
		String newValue = EcoreUtil.convertToString(attr.getEAttributeType(), e.getNewValue());
		
		if(newValue == null)
			newValue = "null";
		
		newValue = newValue.replace(PersistenceManager.DELIMITER, 
				PersistenceManager.ESCAPE_CHAR+PersistenceManager.DELIMITER); //escape delimiter (if any)
		
		printWriter.println(PersistenceManager.SET_EATTRIBUTE_VALUE+" "
				+ePackageElementsNamesMap.getID(attr.getName())+" "
				+changelog.getObjectId(focus_obj)+" ["+newValue+"]");
	}
	
	/*private boolean isInitialEntrySerialised() 
	{
		
		// if output file doesn't exits, initial entry doesn't exist
		File f = new File(manager.getURI().path());
		if(!f.exists() || f.isDirectory())
			return false;
		
		// output file exists, check it for 'namespace' entry
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(new FileInputStream(manager.getURI().path()), manager.TEXT_ENCODING));)
		{
			String line;
			
			if((line = br.readLine()) != null)
			{
				return line.contains("NAMESPACE_URI");
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}*/
	
	private void handleUnsetEAttributeSingleEvent(UnsetEAttributeSingleEvent e)
	{
		EObject focus_obj = e.getFocusObject();
		
		EAttribute attr = e.getEAttribute();
		
		String oldValue = EcoreUtil.convertToString(attr.getEAttributeType(), e.getOldValue());
		
		oldValue = oldValue.replace(PersistenceManager.DELIMITER, 
				PersistenceManager.ESCAPE_CHAR+PersistenceManager.DELIMITER); //escape delimiter (if any)
		
		printWriter.println(PersistenceManager.UNSET_EATTRIBUTE_VALUE
				+" "+ePackageElementsNamesMap.getID(attr.getName())+" "
					+changelog.getObjectId(focus_obj)+" ["+oldValue+"]");
	}
	
	private void handleSetEAttributeManyEvent(SetEAttributeManyEvent e)
	{
		EObject focus_obj = e.getFocusObj();
		EAttribute attr = e.getEAttribute();
		
		List<Object> attr_values_list = e.getAttributeValuesList();
		
		StringBuilder obj_list_blr = new StringBuilder("[");
		
		
		for(Object object: attr_values_list)
		{
			String newValue = (EcoreUtil.convertToString(attr.getEAttributeType(), object));
			
			if(newValue == null)
				newValue = "null";
			
			newValue = newValue.replace(PersistenceManager.DELIMITER, 
					PersistenceManager.ESCAPE_CHAR+PersistenceManager.DELIMITER); //escape delimiter
			
			obj_list_blr.append(newValue).append(PersistenceManager.DELIMITER);
		}
		
		obj_list_blr.substring(0,obj_list_blr.length()-1);
		obj_list_blr.append("]");
		
	
		printWriter.println(PersistenceManager.SET_EATTRIBUTE_VALUE
				+" "+ePackageElementsNamesMap.getID(attr.getName())+" "
				+changelog.getObjectId(focus_obj)+" "+obj_list_blr.toString());
	}
	
	private void handleUnsetEAttributeManyEvent(UnsetEAttributeManyEvent e)
	{
		EObject focus_obj = e.getFocusObj();
		EAttribute attr = e.getEAttribute();
		
		List<Object> attr_values_list = e .getAttributeValuesList();
		
		StringBuilder sb = new StringBuilder("[");
		
		
		for(Object object: attr_values_list)
		{
			String newValue = (EcoreUtil.convertToString(attr.getEAttributeType(), object));
			sb.append(newValue).append(PersistenceManager.DELIMITER);
		}
		
		sb.substring(0,sb.length());
		sb.append("]");
		
		printWriter.println(PersistenceManager.UNSET_EATTRIBUTE_VALUE
				+" "+ePackageElementsNamesMap.getID(attr.getName())+" "
				+changelog.getObjectId(focus_obj)+" "+sb.toString());
	}
	
	private void handleSetEReferenceSingleEvent(SetEReferenceSingleEvent e)
	{
		EObject added_obj = e.getAddedObject();
	
		if(e.getNotifierType() == Event.NotifierType.RESOURCE) //add eobject to resource
		{
			if(changelog.addObjectToMap(added_obj))//make 'create' entries for obj which don't already exist
			{
				StringBuilder sb = new StringBuilder
						().append((PersistenceManager.CREATE_AND_ADD_TO_RESOURCE)).append(" [")
						.append(ePackageElementsNamesMap.getID(added_obj.eClass().getName())).
					append(" ").append(changelog.getObjectId(added_obj)).append("]");
				
				printWriter.println(sb.toString());
			
			}
			else
			{
				StringBuilder sb = new StringBuilder().append(PersistenceManager.ADD_TO_RESOURCE)
						.append(" [").append(changelog.getObjectId(added_obj)).append("]");
				
				printWriter.println(sb.toString());
				
			}
			
		}
		else if(e.getNotifierType() == Event.NotifierType.EOBJECT) //add eobject to eobject
		{
			EObject focus_obj = e.getFocusObject();
			
			if(changelog.addObjectToMap(added_obj))//make 'create' entries for obj which don't already exist
			{
				StringBuilder sb = new StringBuilder().append(PersistenceManager.CREATE_AND_SET_EREFERENCE_VALUE)
						.append(" ").append(ePackageElementsNamesMap.getID(e.getEReference().getName())).append(" ")
						.append(changelog.getObjectId(focus_obj)).append(" ")
						.append("[").append(ePackageElementsNamesMap.getID(added_obj.eClass().getName()))
						.append(" ").append(changelog.getObjectId(added_obj)).append("]");
				
				printWriter.println(sb.toString());
			
			}
			else
			{
				StringBuilder sb = new StringBuilder().append(PersistenceManager.SET_EREFERENCE_VALUE)
						.append(" ").append(ePackageElementsNamesMap.getID(e.getEReference().getName())).append(" ")
						.append(changelog.getObjectId(focus_obj)).append(" ")
						.append("[").append(changelog.getObjectId(added_obj)).append("]");
				
				printWriter.println(sb.toString());
			
			}
		}
	}
	
	private void handleUnsetEReferenceSingleEvent(UnsetEReferenceSingleEvent e)
	{
		EObject removed_obj = e.getRemovedObject();
		long removed_obj_id = changelog.getObjectId(removed_obj);
		
		if(e.getNotifierType() == Event.NotifierType.RESOURCE) //delete eobject from resource
		{
			printWriter.println(PersistenceManager.DELETE_FROM_RESOURCE+" ["+removed_obj_id+"]"); 
			
			changelog.deleteEObjectFromMap(removed_obj);
		}
		else if(e.getNotifierType() == Event.NotifierType.EOBJECT)
		{
			EObject focus_obj = e.getFocusObject();
			
			printWriter.println(PersistenceManager.UNSET_EREFERENCE_VALUE+" "
					+ePackageElementsNamesMap.getID(e.getEReference().getName())+" "+
					changelog.getObjectId(focus_obj)+" ["+removed_obj_id+"]");
			
			changelog.deleteEObjectFromMap(removed_obj);
		}
		
	}
	
	private void handleSetEReferenceManyEvent(SetEReferenceManyEvent e)
	{
		//Stopwatch s = new Stopwatch();
		//s.resume();
		
		StringBuilder added_obj_list_blr = new StringBuilder("[");
		StringBuilder obj_create_list_blr = new StringBuilder("[");
	
		for(EObject obj : e.getEObjectList())
		{
			if(changelog.addObjectToMap(obj)) //if obj does not already exist
			{
				obj_create_list_blr.append(ePackageElementsNamesMap.getID(obj.eClass().getName())).append(" ")
					.append(changelog.getObjectId(obj)).append(PersistenceManager.DELIMITER);
			}
			else //obj exists, i.e we're updating some reference
			{
				added_obj_list_blr.append(changelog.getObjectId(obj)+PersistenceManager.DELIMITER); 
			}
		}
		
		if(e.getNotifierType() == Event.NotifierType.RESOURCE) //updating a resource ref
	    {
			if(obj_create_list_blr.length()>1) //if we have items to create,
			{
				 obj_create_list_blr.substring(0,obj_create_list_blr.length()-1);
				 obj_create_list_blr.append("]");
				 
				 StringBuilder sb = new StringBuilder().append(PersistenceManager.CREATE_AND_ADD_TO_RESOURCE)
						 .append(" ").append(obj_create_list_blr);
				
				 printWriter.println(sb.toString());
			}
			if(added_obj_list_blr.length() > 1) //if we have items to update
			{
				added_obj_list_blr.substring(0,added_obj_list_blr.length()-1);
				added_obj_list_blr.append("]");
				
				StringBuilder sb = new StringBuilder().append(PersistenceManager.ADD_TO_RESOURCE)
						.append(" ").append(added_obj_list_blr);
				
				printWriter.println(sb.toString());
			}
	    }
		else if(e.getNotifierType() == Event.NotifierType.EOBJECT) 
		{
			EObject focus_obj = e.getFocusObj();
			
			if(obj_create_list_blr.length()>1) //if we have items to create
			{
				 obj_create_list_blr.substring(0,obj_create_list_blr.length()-1);
				 obj_create_list_blr.append("]");
				 
				 StringBuilder sb = new StringBuilder().append(PersistenceManager.CREATE_AND_SET_EREFERENCE_VALUE)
						 .append(" ").append(ePackageElementsNamesMap.getID(e.getEReference().getName()))
						 .append(" ").append(changelog.getObjectId(focus_obj)).append(" ").append(obj_create_list_blr);
				 
				 printWriter.println(sb.toString());
			}
			if(added_obj_list_blr.length() > 1)
			{
				added_obj_list_blr.substring(0,added_obj_list_blr.length()-1);
				added_obj_list_blr.append("]");
				
				StringBuilder sb = new StringBuilder().append(PersistenceManager.SET_EREFERENCE_VALUE)
						.append(" ").append(ePackageElementsNamesMap.getID(e.getEReference().getName()))
						.append(" ").append(changelog.getObjectId(focus_obj)).append(" ")
						.append(added_obj_list_blr);
				
				printWriter.println(sb.toString());
			}   	
		}
		
	 //  s.pause();
	    
	   // System.out.println("Time taken : "+ s.getElapsed());
	   // System.exit(0);
	    
	}
	
	private void handleUnsetEReferenceManyEvent(UnsetEReferenceManyEvent e)
	{
		List<EObject> removed_obj_list = e.getObjectList();
		
		String obj_delete_list_str = "["; 
		StringBuilder sb = new StringBuilder("]");//list of obj to delete
		
		for (EObject obj : removed_obj_list)
		{
			long removed_obj_id = changelog.getObjectId(obj);
			
			obj_delete_list_str = obj_delete_list_str+removed_obj_id +PersistenceManager.DELIMITER; 
			sb.append(removed_obj_id).append(PersistenceManager.DELIMITER);
			
			changelog.deleteEObjectFromMap(obj);	
		}
		
		obj_delete_list_str = obj_delete_list_str.substring(0,obj_delete_list_str.length()-1)+"]";
		
		if(e.getNotiferType() == Event.NotifierType.RESOURCE) //DELETE OBJs FROM RESOURCE
		{
			printWriter.println(PersistenceManager.DELETE_FROM_RESOURCE+" "+obj_delete_list_str);
		}
		else if(e.getNotiferType() == Event.NotifierType.EOBJECT)
		{
			EObject focus_obj = e.getFocusObj();
			
			printWriter.println(PersistenceManager.UNSET_EREFERENCE_VALUE+" "
					+(ePackageElementsNamesMap.getID(e.getEReference().getName())+" "
					+changelog.getObjectId(focus_obj)+" "+obj_delete_list_str));
		}	
	
	}
	
	private void serialiseInitialEntry() 
	{
		EObject obj = null;
		Event e = eventList.get(0);
		
		switch(e.getEventType())
		{
		case Event.SET_EREFERENCE_SINGLE:
			obj = ((SetEReferenceSingleEvent)e).getAddedObject();
			break;
		case Event.SET_EREFERENCE_MANY:
			obj = ((SetEReferenceManyEvent)e).getEObjectList().get(0);
			break;
		default:
			try 
			{
				System.out.println(e.getEventType());
				throw new Exception ("Error! first item in events list was not an Add event.");
			} catch (Exception e1) 
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.exit(0);
			}
		}
		
		if(obj == null)
		{
			System.out.println(e.getEventType());
			System.exit(0);
		}
		
	
		printWriter.println(FORMAT_ID+" "+VERSION);
		printWriter.println("NAMESPACE_URI "+obj.eClass().getEPackage().getNsURI());
	}
}
