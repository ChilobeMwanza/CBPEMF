package generated_emf_tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.junit.After;
import org.junit.Test;

import impl.DeltaResourceImpl;
import university.University;
import university.UniversityFactory;
import university.UniversityPackage;

public class SystemTest extends TestBase 
{
	private EPackage ePackage = null;
	private List<EObject> savedContentsList = null;
	private List<EObject> loadedContentsList = null;
	
	
	
	//@Override
	/*public void runOnceBeforeTest()
	{
		super.runOnceBeforeTest();
		  
	    //Register epackage reflectively
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
			    "ecore", new EcoreResourceFactoryImpl());Resource.Factory.Registry.INSTANCE.
			    getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl()); 
		
		
		ResourceSet rs = new ResourceSetImpl();
		
		Resource r = rs.getResource(URI.createFileURI(ECORE_FILE_LOCATION), true);
		
		EObject eObject = r.getContents().get(0);
		
		if (eObject instanceof EPackage) 
		{
		    ePackage = (EPackage)eObject;
		    EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
		    rs.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
		}	
	}*/
	
	
	
	
	
	
}
