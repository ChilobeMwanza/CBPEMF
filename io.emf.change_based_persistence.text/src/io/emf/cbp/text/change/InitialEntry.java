package io.emf.cbp.text.change;

import org.eclipse.emf.ecore.EObject;

public class InitialEntry extends Entry
{
	private String namespacePrefix;
	private String namespaceURI;
	private String className;
	
	public InitialEntry(EObject eObject) 
	{
		super(eObject);
		
		namespacePrefix = eObject.eClass().getEPackage().getNsPrefix();
		System.out.println("Namespace prefix: "+namespacePrefix);
		
		namespaceURI = eObject.eClass().getEPackage().getNsURI();
		System.out.println("NamespaceURI:"+namespaceURI);
		
		className = eObject.getClass().getSimpleName();
		System.out.println("Class Name: "+className);
	}
	
}
