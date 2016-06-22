package main;

import java.io.File;
import java.io.FileOutputStream;

//import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import library.Book;
import library.Library;
import library.LibraryFactory;

public class App 
{
	private static String fileSaveLocation ="library.xmi";
	
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		App app = new App();
		app.createResource();
	}
	
	public void createResource() throws Exception
	{
		
		final LibraryFactory libFac = LibraryFactory.eINSTANCE;
		
		EventAdapter adapter = new EventAdapter();
		//AnotherAdapter adapter = new AnotherAdapter();
		
	

		Resource resource = new XMIResourceImpl();
		resource.eAdapters().add(adapter);
		
		Library lib = LibraryFactory.eINSTANCE.createLibrary();
		
	    resource.getContents().add(lib);
		
	    
	    Book book = LibraryFactory.eINSTANCE.createBook();
	    lib.getBooks().add(book);
	    
	  //  book.setName("A Book");
		
	//	lib.eAdapters().add(adapter);
	
		
		
	
		
		
	//	Book book = libFac.createBook();
		//lib.getBooks().add(book);
		
		//book.setName("A Book");
		//book.setIdNumber(4);
		
		
	
		
		//resource.save(new FileOutputStream(new File(fileSaveLocation)),null);
		
       //System.out.println("Saved");
	}

}
