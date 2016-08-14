
//add tests for adding null values to list or direct e.t.c
package tests;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.After;
import org.junit.Test;

import impl.DeltaResourceImpl;
import university.University;
import university.UniversityFactory;


public class SetUnsetAttributeTests extends TestBase
{
	private List<EObject> savedContentsList = null;
	private List<EObject> loadedContentsList = null;
	
	
	@After
	public void runAfterTestMethod()
	{
		savedContentsList = null;
		loadedContentsList = null;
	}
	/*
	 * Tests setting value of 1 single valued attribute
	 */
	@Test
	public void testSetOneSingleValuedAttribute() throws IOException
	{
		Resource res = new DeltaResourceImpl(URI.createURI(fileSaveLocation));
		
		University uni = UniversityFactory.eINSTANCE.createUniversity();
		res.getContents().add(uni);
		
		uni.setName("York Uni");
		
		res.save(null);
		
		savedContentsList = getResourceContentsList(res);
		
		Resource loadedRes = loadResource();
		
		loadedContentsList = getResourceContentsList(loadedRes);
		
		assertTrue(EcoreUtil.equals(savedContentsList, loadedContentsList));
	}
	
	@Test
	public void testUnsetOneSingleValuedAttribute() throws IOException
	{
		Resource res = new DeltaResourceImpl(URI.createURI(fileSaveLocation));
		
		University uni = UniversityFactory.eINSTANCE.createUniversity();
		res.getContents().add(uni);
		
		uni.setName("York Uni");
		uni.setName(null);
		
		res.save(null);
		
		savedContentsList = getResourceContentsList(res);
		
		Resource loadedRes = loadResource();
		
		loadedContentsList = getResourceContentsList(loadedRes);
		
		assertTrue(EcoreUtil.equals(savedContentsList, loadedContentsList));
	}
}
