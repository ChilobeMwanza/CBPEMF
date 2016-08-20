package generated_emf_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;

import impl.DeltaResourceImpl;
import university.University;
import university.UniversityFactory;
import university.UniversityPackage;

public class GeneralSaveTests extends TestBase
{
	/*Calling save() serialises all monitored changes (notifications) and clears these
	 * Notifications from the event list. Calling save repeatedly without having made
	 * any changes to the model should not result in subsequent modifications of the save
	 * file.
	 */
	@Test
	public void testRepeatedSaveNoModification() throws IOException
	{
		Resource res = new DeltaResourceImpl(URI.createURI(fileSaveLocation),ePackage);
		
		University uni1 = UniversityFactory.eINSTANCE.createUniversity();
		res.getContents().add(uni1);
		
		//perform first save
		res.save(null);
		
		//save last modified time
		File file = new File(fileSaveLocation);
		Long timeStamp = file.lastModified();
		
		//perform further saves without modifiying the resource
		res.save(null);
		res.save(null);
		
		
		//check that the file has not been modified
		assertTrue(timeStamp == file.lastModified());
	}
	
	/*
	 * Test that making initial modifications, calling save, making more modifications,
	 *  results in the save file being modified accordingly.
	 */
	@Test
	public void testMultipleSaveWithModifications() throws IOException, InterruptedException
	{
		Resource res = new DeltaResourceImpl(URI.createURI(fileSaveLocation),ePackage);
		University uni1 = UniversityFactory.eINSTANCE.createUniversity();
		res.getContents().add(uni1);
		
		//perform first save
		res.save(null);
		
		//save last modified time
		File file = new File(fileSaveLocation);

		Long timeStamp = file.lastModified();
		
		//make further modifications
		uni1.setName("York University");
		
		//wait a little before save to ensure modification does not happen too quickly
		Thread.sleep(10);
		
		res.save(null);
		
		//check that the file has been modified
		assertFalse(timeStamp == file.lastModified());
		
	}
	
	/*
	 * Test that saved object and loaded object are equal
	 */
	@Test
	public void testBasicSaveAndLoad() throws IOException
	{
		Resource savedRes = new DeltaResourceImpl(URI.createURI(fileSaveLocation),ePackage);
		
		University savedUni = UniversityFactory.eINSTANCE.createUniversity();
		
		savedRes.getContents().add(savedUni);
		
		savedRes.save(null);
		
		//Load in the resource
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		("txt", new Resource.Factory()
		{
			@Override
			public Resource createResource(URI uri)
			{
				return new DeltaResourceImpl(uri,ePackage);
			}
		});
		
		rs.getPackageRegistry().put(UniversityPackage.eINSTANCE.getNsURI(), 
				UniversityPackage.eINSTANCE);
		
		Resource loadedRes = rs.createResource(URI.createFileURI(fileSaveLocation));
		loadedRes.load(null);
		
		//check objects are equal
		
		University loadedUni = (University) loadedRes.getContents().get(0);
		
		assertTrue(EcoreUtil.equals(savedUni, loadedUni));
	}
	
	
	/*
	 * Test empty save does not result in output file creation
	 */
	@Test
	public void testEmptySave() throws IOException
	{
		Resource res = new DeltaResourceImpl(URI.createURI(fileSaveLocation),ePackage);
		res.save(null);
		
		File f = new File(fileSaveLocation);
		
		assertFalse(f.exists());
	}
	
	/*
	 * Tests that redundant modifications, after load, do not result in changes to the output file
	 */
	@Test
	public void testRedundantModification() throws IOException
	{
		Resource res = new DeltaResourceImpl(URI.createURI(fileSaveLocation),ePackage);
		
		University savedUni = UniversityFactory.eINSTANCE.createUniversity();
		
		res.getContents().add(savedUni);
		
		savedUni.setName("York Uni");
		
		res.save(null);
		
		File file = new File(fileSaveLocation);
		Long timeStamp = file.lastModified();
		
		
		//Load in the resource
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		("txt", new Resource.Factory()
		{
			@Override
			public Resource createResource(URI uri)
			{
				return new DeltaResourceImpl(uri,ePackage);
			}
		});
		
		rs.getPackageRegistry().put(UniversityPackage.eINSTANCE.getNsURI(), 
				UniversityPackage.eINSTANCE);
		
		Resource loadedRes = rs.createResource(URI.createFileURI(fileSaveLocation));
		loadedRes.load(null);
		
		University loadedUni = (University) res.getContents().get(0);
		loadedUni.setName("York Uni");
		
		//check that the file has not been modified
		assertTrue(timeStamp == file.lastModified());
	}
}
