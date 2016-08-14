package dynamic_emf_tests;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.junit.*;

import impl.DeltaResourceImpl;

public abstract class TestBase 
{
	protected static final String FILE_SAVE_LOCATION = "university.txt";
	protected static final String ECORE_FILE_LOCATION = new File("").getAbsolutePath()+"/model/university.ecore";
	private static EPackage ePackage = null;
	private static String classname = "dynamic_emf_tests::TestBase";
	
	@BeforeClass
	public static void runOnceBeforeClass()
	{
		/*Dynamically register epackage */
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().
			put("ecore", new EcoreResourceFactoryImpl())
			;Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().
			put("*", new EcoreResourceFactoryImpl()); 
	
		ResourceSet rs = new ResourceSetImpl();
				
		Resource r = rs.getResource(URI.createFileURI(ECORE_FILE_LOCATION), true);
		
		EObject eObject = r.getContents().get(0);
		
		if (eObject instanceof EPackage) 
		{
		    ePackage = (EPackage)eObject;
		    EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
		    rs.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
		}
		else
		{
			System.out.println(classname+" Error! Could not register epackage!");
			System.exit(0);
		}
	}
	
	@AfterClass
	public static void runOnceAfterClass()
	{
		ePackage = null;
	}
	
	@Before
	public void runOnceBeforeTest()
	{
		/*Delete save file if it exists*/
		File file = new File(FILE_SAVE_LOCATION);
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
		
		rs.getPackageRegistry().put(ePackage.getNsURI(), 
				ePackage);
		
		Resource res = rs.createResource(URI.createFileURI(FILE_SAVE_LOCATION));
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
	
	protected EObject createEObject(String eClassName) //does this need to be a method?
	{
		return ePackage.getEFactoryInstance().create((EClass)
				ePackage.getEClassifier(eClassName));
	}
	
}
