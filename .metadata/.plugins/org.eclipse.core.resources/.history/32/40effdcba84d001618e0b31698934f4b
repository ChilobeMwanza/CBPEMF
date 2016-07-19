//A new object has been created.

package change;
import java.util.UUID;

//tbr
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;

public class NewObjectEntry extends AbstractEntry
{
	public NewObjectEntry(EObject value, UUID id)
	{
		super(value, id);
	}
	
	public NewObjectEntry(Notification msg, UUID id)
	{
		this((EObject)msg.getNotifier(),id) ;
	}

}
