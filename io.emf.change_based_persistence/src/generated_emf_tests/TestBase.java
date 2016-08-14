
package generated_emf_tests;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.junit.*;

import impl.DeltaResourceImpl;
import university.UniversityPackage;

public abstract class TestBase 
{
	protected static String fileSaveLocation ="university.txt";
	
	@Before
	public void runOnceBeforeTest()
	{
		/*Delete save file if it exists*/
		File file = new File(fileSaveLocation);
		try {
			Files.deleteIfExists(file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected Resource loadResource()
	{
		//Load persisted model into resource contents
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		("txt", new Resource.Factory()
		{
			@Override
			public Resource createResource(URI uri)
			{
				return new DeltaResourceImpl(uri);
			}
		});
		
		rs.getPackageRegistry().put(UniversityPackage.eINSTANCE.getNsURI(), 
				UniversityPackage.eINSTANCE);
		
		Resource res = rs.createResource(URI.createFileURI(fileSaveLocation));
		try {
			res.load(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	protected List<EObject> getResourceContentsList(Resource res)
	{
		List<EObject> outputList = new ArrayList<EObject>();
		for(TreeIterator<EObject> it = res.getAllContents(); it.hasNext();)
		{	
			outputList.add(it.next());
		}
		return outputList;
	}
}
