package drivers;
/**
 * Maps the names of EClasses and EStructuralFeatures (within an EPackage) to 
 * unique numerical ids.
 * 
 * @author Chilobe Mwanza
 * @Version 1.0
 * @Since 2016-08-18
 */

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class EPackageElementsNamesMap
{
	private BiMap<String, Integer> namesMap = HashBiMap.create();
	
	int counter = 0;
	
	public void addName(String name)
	{
		if(namesMap.get(name) == null)
		{
			namesMap.put(name, counter);
			counter = counter +1;
		}
	}
	
	public int getID(String name)
	{
		return namesMap.get(name);
	}
	
	public String getName(int id)
	{
		return namesMap.inverse().get(id);
	}
}
