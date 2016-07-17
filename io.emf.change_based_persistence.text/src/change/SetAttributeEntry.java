/*
 * Based on Neo4EMF 'SetAttribute' class 
 *  available at  https://github.com/neo4emf/Neo4EMF/blob/e6b84f81b42d3d0d5ef173c4eb7e6967442ffa8d/fr.inria.atlanmod.neo4emf/src/main/java
 *  /fr/inria/atlanmod/neo4emf/change/impl/SetAttribute.java
 *  
 *  Used under terms of Eclipse Public License v 1.0
 *  
 *  Original author Gerson Sunyé
 */

package change;

import java.util.UUID;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

public class SetAttributeEntry extends AbstractEntry
{
	private final EAttribute eAttribute;
	private final Object newValue;
	
	
	public SetAttributeEntry(EObject obj, EAttribute eAttribute, Object newValue, UUID id)
	{
		super(obj, id);
		this.newValue = newValue;
		this.eAttribute = eAttribute;
	}
	
	public SetAttributeEntry(Notification msg, UUID id)
	{
		this((EObject)msg.getNotifier(),(EAttribute)msg.getFeature(),msg.getNewValue(), id);
	}
	
	public EAttribute geteAttribute() 
	{
		return eAttribute;
	}
	
	public Object getNewValue() 
	{
		return newValue;
	}	
}
