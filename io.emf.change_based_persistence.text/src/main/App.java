/**
 * BUGS/ISSUES
 * 1) In order for this implementation to work, newly created model elements
 * must be added directly to the resource, or added to an object that who's hierachy
 * eventually leads to the resource. 
 */

package main;


import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
//import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;


import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import impl.DeltaResourceImpl;
import library.Author;
import library.Book;
import library.Library;
import library.LibraryFactory;
import library.LibraryPackage;
import library.LibraryType;


public class App 
{
	private static String fileSaveLocation ="library.txt";
	
	public static void main(String[] args) throws Exception
	{
		
	

		List<EObject> savedList = new ArrayList<EObject>();
		List<EObject> loadedList = new ArrayList<EObject>();
		
		// TODO Auto-generated method stub
		App app = new App();
		
		savedList = app.createResource();
		loadedList = app.loadResource() ;
	
		app.verify(savedList, loadedList);
	
		
	}
	
	public List<EObject> loadResource() throws IOException
	{
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
		
		rs.getPackageRegistry().put(LibraryPackage.eINSTANCE.getNsURI(), 
				LibraryPackage.eINSTANCE);
		
		Resource resource = rs.createResource(URI.createFileURI(fileSaveLocation));
		resource.load(null);
		
		//Map<String, String> loadOptions = new HashMap<String, String>();
		//loadOptions.put("FILE_LOCATION", fileSaveLocation);
		
		List<EObject> objectsList = new ArrayList<EObject>();
		
		for(TreeIterator<EObject> it = resource.getAllContents(); it.hasNext();)
		{
			objectsList.add(it.next());
		}
		
		resource.getContents().clear();
		
		return objectsList;
		
	}
	
	public List<EObject> createResource() throws Exception
	{
		//Resource resource = new XMIResourceImpl(URI.createURI("library.txt"));
		
		Resource resource = new DeltaResourceImpl(URI.createURI("library.txt"));
		
		
		Library lib = LibraryFactory.eINSTANCE.createLibrary();
		
		
		
		resource.getContents().add(lib);
		List<String> list = new ArrayList<String>();
		list.add("Chris K");
		list.add("Jerome Black");
		
		lib.getEmployeeNames().addAll(list);
		
		lib.getEmployeeNames().add("Jacob Black");
		lib.getEmployeeNames().add("April Brown");
		
	//	lib.getEmployeeNames().add("4");
		
		
		//Library lib3 = LibraryFactory.eINSTANCE.createLibrary();
	//	lib3.getBadBooks().add(book1);
		
		
		
		//resource.getContents().add(lib2); 

		//Map<String, String> saveOptions = new HashMap<String, String>();
		//saveOptions.put("FILE_SAVE_LOCATION", fileSaveLocation);
		
		resource.save(null); 
		List<EObject> objectsList = new ArrayList<EObject>();
		
		for(TreeIterator<EObject> it = resource.getAllContents(); it.hasNext();)
		{
			objectsList.add(it.next());
		}
		resource.getContents().clear();
		
		return objectsList;
	}
	
	private void verify(List<EObject> savedList, List<EObject>loadedList)
	{
		/* Verify that saved and serialised data are the same*/
		if(EcoreUtil.equals(savedList, loadedList))
		{
			out("Serialsed data Verified!");
			return;
		}
		else
		{
			out("verificaiton failed! attempting to find cause of failure!");
		}
		
		
		/* Check saved list and loaded list contain same number of elements*/
		if(savedList.size() != loadedList.size())
		{
			out(" : mismatch between savedList size and loadedList size");
			System.exit(0);
		}
	
		
		
		/* Compare attributes and their values */
		for(int i = 0; i < savedList.size(); i++)
		{
			EObject obj1 = savedList.get(i);
			EObject obj2 = loadedList.get(i);
			
		
			/*Comapare attributes*/
			for(EAttribute attr1 : obj1.eClass().getEAllAttributes()) //e vs eall
			{
				for(EAttribute attr2 : obj2.eClass().getEAllAttributes())
				{
					if(attr1 == attr2 && obj1.eIsSet(attr1))
					{
						
						Object value1 = obj1.eGet(attr1);
						Object value2 = obj2.eGet(attr2);
					
						
						if(value1.hashCode() != value2.hashCode())
						{
							out(" mismatched attributes :");
							out(obj1.eClass().getName()+"1 attribute : "+attr1.getName() + " value: "+obj1.eGet(attr1).toString());
							out(obj2.eClass().getName()+"2 attribute : "+attr2.getName() + " value: "+obj2.eGet(attr2).toString());
							System.exit(0);
						}
					}
				}
			}
		}
		
		out("Failed to find reason for verification failure! Have you implemented the logic ?");
		
	}
	
	
	
	private void out(String str)
	{
		System.out.println(this.getClass().getSimpleName()+": "+str);
	}
	
	private void out(Boolean bool)
	{
		System.out.println(this.getClass().getSimpleName()+": "+bool);
	}

}
