package io.emf.cbp.text.change;

import org.eclipse.emf.ecore.EObject;

public class Entry 
{
	private final EObject eObject;
	
	public Entry(EObject obj)
	{
		eObject = obj;
	}
	
	public EObject getEObject()
	{
		return eObject;
	}
}
