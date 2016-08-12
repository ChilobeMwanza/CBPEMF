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
import util.KDebug;


public class ChangeLog 
{
	private final List<Notification> notificationsList;
	private final BiMap<EObject,Long> map; 
	private final String classname = this.getClass().getSimpleName();
	
	/* needs to be static so we can track the latest (highest) available 
	 * id globally across instantiations of this changelog. A new changelog is instantiated 
	 * at save and at load. if this var is not static, current id reverts to 0*/
	private static long current_id; 
	
	public ChangeLog()
	{
		notificationsList = new ArrayList<Notification>();
		map = HashBiMap.create();
		current_id = 0;
	}
	
	public BiMap<EObject,Long> getObjectToIdMap()
	{
		return map;
	}
	
	public boolean addObjectToMap(EObject obj)
	{
	
		if(map.get(obj)== null)
		{
			map.put(obj, current_id);
			current_id = current_id + 1; //update
			return true;
		}	
		return false;
	}
	
	public boolean deleteEObjectFromMap(long id)
	{
		map.remove(id);
		return true;
	}
	
	public boolean addObjectToMap(EObject obj, long id)
	{
		if(getEObject(id) == null)
		{
			map.put(obj, id);
			
			if(id >= current_id)
			{
				current_id = id + 1;
			}
			return true;
		}	
		return false;
	}
	
	public long getObjectId(EObject obj)
	{
		long id = -1;
		
		if(map.get(obj)!= null)
			id = map.get(obj);
		
		return id;
	}
	
	public EObject getEObject(long id)
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
}
