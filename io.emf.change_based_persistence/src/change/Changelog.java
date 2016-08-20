package change;

import java.util.ArrayList;

import java.util.List;


import org.eclipse.emf.ecore.EObject;

import gnu.trove.map.TObjectIntMap;
import gnu.trove.map.hash.TObjectIntHashMap;


public class Changelog 
{
	private final List<Event> event_list;
	
	private final TObjectIntMap<EObject> eObjectToIDMap = new TObjectIntHashMap<EObject>();

	private final String classname = this.getClass().getSimpleName();
	
	/* needs to be static so we can track the latest (highest) available 
	 * id globally across instantiations of this changelog. A new changelog is instantiated 
	 * at save and at load. if this var is not static, current id reverts to 0*/
	private static int current_id = 0; 
	
	public Changelog()
	{
		event_list = new ArrayList<Event>();
	}
	
	
	
	/*public BiMap<EObject,Long> getObjectToIdMap()
	{
		return map;
	}*/
	
	public boolean addObjectToMap(EObject obj)
	{
	
		if(!eObjectToIDMap.containsKey(obj))
		{
			eObjectToIDMap.put(obj, current_id);
			
			current_id = current_id +1;
			return true;
		}
		return false;
	}
	
	public boolean addObjectToMap(EObject obj, int id)
	{
		if(!eObjectToIDMap.containsKey(obj))
		{
			eObjectToIDMap.put(obj, id);
			
			if(id >= current_id)
			{
				current_id = id + 1;
			}
			return true;
		}
		return false;
	}
	
	public void deleteEObjectFromMap(EObject obj)
	{
		
		
		eObjectToIDMap.remove(obj);
		
		if(eObjectToIDMap.containsKey(obj)) //tbr
		{
			System.out.println(classname+ " nope!!");
			System.exit(0);
		}
		
	}
	
	
	
	public long getObjectId(EObject obj)
	{
	
		if(!eObjectToIDMap.containsKey(obj)) //tbr
		{
			System.out.println(classname+" search retrun false");
			System.exit(0);
		}
		return eObjectToIDMap.get(obj);
	
	}
	
	/*public EObject getEObject(long id)
	{
		return  map.inverse().get(id);
	}*/
	
	public void addEvent(Event e)
	{
		event_list.add(e);
	}
	
	public void removeEvent(Event e)
	{
		event_list.remove(e);
	}
	
	public void clearEvents()
	{
		event_list.clear();
	}
	
	public List<Event> getEventsList()
	{
		return event_list;
	}
}
