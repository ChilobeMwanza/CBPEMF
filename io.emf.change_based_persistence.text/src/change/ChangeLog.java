package change;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import impl.DeltaResourceImpl;


public class ChangeLog 
{
	private final List<Notification> notificationsList;
	private final BiMap<EObject,Double> map; //change to normal map
	
	private Double count;
	
	public ChangeLog()
	{
		notificationsList = new ArrayList<Notification>();
		map = HashBiMap.create();
		count = 0.0;
	}
	
	public BiMap<EObject,Double> getObjectToIdMap()
	{
		return map;
	}
	
	public boolean addObjectToMap(EObject obj)
	{
		//System.out.println(obj.eClass().getName());
		if(map.get(obj) == null)
		{
			map.put(obj, count++);
			return true;
		}	
		return false;
	}
	public boolean addObjectToMap(EObject obj, double id)
	{
		if(map.get(obj) == null)
		{
			map.put(obj, id);
			return true;
		}	
		return false;
	}
	
	public double getObjectId(EObject obj)
	{
		double id;
		if(map.get(obj)!= null)
			id = map.get(obj);
		else
			id = -1;
		
		return id;
	}
	
	public EObject getEObject(double id)
	{
		return  map.inverse().get(id);
	}
	
	public void addNotification(Notification n)
	{
		notificationsList.add(n);
	}
	
	public List<Notification> getEventsList()
	{
		return notificationsList;
	}
	
	/*public List<AbstractEntry> sortChangeLog()
	{
		return sortChangeLog(eventsList);
	}*/
	

	/*
	public List<AbstractEntry> sortChangeLog(List<AbstractEntry> list)
	{
		
		List<AbstractEntry> newObjectEntryList = new ArrayList<AbstractEntry>();
		List<AbstractEntry> setAttrSingleList = new ArrayList<AbstractEntry>();
		List<AbstractEntry> setAttrManyList = new ArrayList<AbstractEntry>();
		
		
		for(AbstractEntry e: list)
		{
			if(e instanceof NewObjectEntry)
				newObjectEntryList.add(e);
			else if(e instanceof SetAttributeEntry)
			{
				SetAttributeEntry s = (SetAttributeEntry)e;
				if(s.geteAttribute().isMany())
					setAttrManyList.add(e);
				else
					setAttrSingleList.add(e);
			}	
		}
		
		
		List<AbstractEntry> sortedList = new ArrayList<AbstractEntry>();
		for(AbstractEntry a : newObjectEntryList)
		{
			sortedList.add(a);
			for(AbstractEntry b: setAttrSingleList) //get all set 'attribute single entries' for this item
			{
				if(b.getID() == a.getID())
					sortedList.add(b);
			}
			for(AbstractEntry c : setAttrManyList) //get all 'set attribute many' entries for this item
			{
				if(c.getID() == a.getID())
					sortedList.add(c);
			}
			
		}
		
		return sortedList;
	} */
	
	/*public void showLogEntries(List<AbstractEntry> list)
	{
		for(AbstractEntry e : list)
		{
			
			if(e instanceof NewObjectEntry)
				//System.out.println("CREATE "+e.getEObject().eClass().getName()+" "+e.getID().toString());
			
			if(e instanceof SetAttributeEntry)
			{
				SetAttributeEntry s = (SetAttributeEntry)e;
				//System.out.println("SET " + e.getEObject().eClass().getName()+" "+e.getID()+" "+s.geteAttribute().getName());
			}
		}
	}
	
	public void showLogEntries()
	{
		showLogEntries(eventsList);
	}*/
}
