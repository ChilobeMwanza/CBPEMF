/*
 * Creates a library model, persists it then reads it in using the default XMI serialisation.
 */
package main;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.common.util.URI;

import library.Book;
import library.Employee;
import library.Library;
import library.LibraryPackage;

public class XMIPersistence extends EMFPersistence
{

	private static String fileSaveLocation ="library.xmi";
	
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
		
		XMIPersistence App = new XMIPersistence();
	
		App.createResource();
	    //App.loadResource();
	}

	public void createResource() throws Exception
	{
		Resource resource = new XMIResourceImpl();
		
		/*Create Library model (and all its associated elements*/
		Library lib = createLibraryModel(resource);
		
		/*Persist Library model in xmi format*/ 
	
		resource.getContents().add(lib);
		resource.save(new FileOutputStream(new File(fileSaveLocation)),null);	
	}
	
	public void loadResource() throws Exception
	{
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(LibraryPackage.eINSTANCE.getNsURI(), LibraryPackage.eINSTANCE);
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
