package change;

import java.util.UUID;

import org.eclipse.emf.ecore.EObject;
//can be far simpler. don't need a whole class just to get namespace uri
public class InitialEntry extends AbstractEntry  //doesn't need an id, but that's how things are working for now
{
	//private String namespacePrefix;
	private String namespaceURI;
	//private String className;
	
	public InitialEntry(EObject eObject) 
	{
		super(eObject, UUID.randomUUID());
		
		//namespacePrefix = eObject.eClass().getEPackage().getNsPrefix();
		//System.out.println("Namespace prefix: "+namespacePrefix);
		
		namespaceURI = eObject.eClass().getEPackage().getNsURI(); //tbr
		//System.out.println("NamespaceURI:"+namespaceURI);
		
	//	className = eObject.eClass().getName();
		//System.out.println("Class Name: "+className);
	}
	
	public String[] getOutputStringsArray() //not used
	{
		String[] outputStrings = new String[1];
		
		//outputStrings[0] = "namespace prefix = "+namespacePrefix;
		outputStrings[0] = "NAMESPACEURI = "+namespaceURI;
		//outputStrings[2] ="classname = "+className;
		
		return outputStrings;
	}
	
}
