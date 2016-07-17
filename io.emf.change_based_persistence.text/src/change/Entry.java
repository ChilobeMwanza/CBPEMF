package change;

import java.util.UUID;

import org.eclipse.emf.ecore.EObject;

public interface Entry 
{
	public EObject getEObject();
	public UUID getUUID();
}
