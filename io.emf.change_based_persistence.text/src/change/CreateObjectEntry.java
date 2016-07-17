package change;

import org.eclipse.emf.ecore.EObject;
//tbr
public class CreateObjectEntry //tbr
{
	String className ; //The class of the object
	
	
	public CreateObjectEntry(EObject eObject)
	{
		//super(eObject);
		className = eObject.eClass().getName();
	}
	
	
}
