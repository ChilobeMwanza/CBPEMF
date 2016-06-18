/*
 * Creates a library model, persists it then reads it in using EMF binary resource.
 */
package main;

import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.common.util.URI;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.eclipse.emf.ecore.resource.Resource;

import library.Book;
import library.Employee;
import library.Library;
import library.LibraryPackage;

public class BinaryPersistence extends ModelCreator
{
	private static String fileSaveLocation ="library.bin";
	
	public static void main(String[] args) throws Exception
	{
		/*
		 * Use specified file save location (if any)
		 */
		if(args.length == 1)
		{
			//check file path is valid before attempting to set it as save location
			try
			{
				Paths.get(args[0]);
				fileSaveLocation = args[0];
			}
			catch(Exception e)
			{
				System.out.println("Error with file save location");
				e.printStackTrace();
			}
			System.out.println(args[0]);
		}
		
		BinaryPersistence App = new BinaryPersistence();
		App.createResource();
		App.loadResource();
	}
	
	public void createResource() throws Exception
	{
		Resource resource = new BinaryResourceImpl();
		
		/*Create Library model (and all its associated elements*/
		Library lib = createLibraryModel(resource);
		
		/*Persist Library model in xmi format*/ 
		resource.getContents().add(lib);
		
		resource.save(new FileOutputStream(new File(fileSaveLocation)),null);
	}
	
	public void loadResource() throws Exception 
	{
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		("bin", new Resource.Factory()
		{
			@Override
			public Resource createResource(URI uri)
			{
				return new BinaryResourceImpl(uri);
			}
		});
		
		rs.getPackageRegistry().put(LibraryPackage.eINSTANCE.getNsURI(), 
				LibraryPackage.eINSTANCE);
		Resource resource = rs.createResource(URI.createFileURI(fileSaveLocation));
		
		resource.load(null);
		
        Library lib = (Library)resource.getContents().get(3); //"Contents (0-2) contains Author objects"
		
		System.out.println("The library contains the following books: \n");
		for(Book b: lib.getBooks())
		{
			System.out.println(b.getName()+" by "+b.getAuthor().getName());
		}
		
		System.out.println("");
		System.out.println("The library has the following employees: \n");
		for(Employee employee : lib.getEmployees())
		{
			System.out.println(employee.getName()+". Type: "+employee.getEmployeeType().getName());
		}
	}
}
