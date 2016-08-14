/**
 * BUGS/ISSUES
 */

package main;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import com.google.common.hash.HashCode;
import com.google.common.io.Files;

import impl.DeltaResourceImpl;
import university.Book;
import university.University;
import university.UniversityFactory;
import university.UniversityPackage;


public class App 
{
	private static String fileSaveLocation ="university.txt";
	private  final String classname = this.getClass().getSimpleName();
	
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		App app = new App();
		//app.loadResource() ;
		app.createResource();
	
		for(int i = 0; i < 500; i++)
		{
			System.out.println("App round:"+i);
			app.test();
		}
	
	}
	
	
	public void loadResource() throws IOException
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
		
		rs.getPackageRegistry().put(UniversityPackage.eINSTANCE.getNsURI(), 
				UniversityPackage.eINSTANCE);
		
		Resource resource = rs.createResource(URI.createFileURI(fileSaveLocation));
		resource.load(null);
		
		University uni1 = (University) resource.getContents().get(0);
		uni1.setName("Leeds Uni");
		resource.save(null);
	}
	
	public void test() throws IOException
	{
		//Resource res = new DeltaResourceImpl(URI.createURI(fileSaveLocation));
		Resource res = new XMIResourceImpl(URI.createURI("library.txt"));
		//resource.getContents().clear();
		//initial modifications
		University uni1 = UniversityFactory.eINSTANCE.createUniversity();
		res.getContents().add(uni1);
		
		
		
		
		//perform first save
		res.save(null);
		
		//save last modified time
		File file = new File("library.txt");
		//File file = new File(fileSaveLocation);

		
		Long timeStamp = file.lastModified();
		
		/*
		 * File modification may be so fast that the modified time remains the same, 
		 * so wait a little before modifying time
		 */
		/*try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//make further modifications
		uni1.setName("York University");
		uni1.setName("Leeds Uni");
		uni1.setName("Man U Uni");
		
		res.save(null);
		
		//check that the file has been modified
		
		File file2 = new File("library.txt");
		if(file2.lastModified() == file.lastModified())
		{
			System.out.println(classname+" error!");
			System.exit(0);
		}
	}
	
	public void createResource() throws Exception
	{
		
		Resource resource = new DeltaResourceImpl(URI.createURI(fileSaveLocation));
	
		//initial modifications
		University uni1 = UniversityFactory.eINSTANCE.createUniversity();
		resource.getContents().add(uni1);
				
		//perform first save
		resource.save(null);
		
		uni1.setName("York University");
		
		/*SAVE STARTS HERE*/
		resource.save(null); 
	}
}
