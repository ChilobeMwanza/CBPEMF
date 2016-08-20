/**
 * BUGS/ISSUES
 */

package main;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;



import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
//import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import com.google.common.hash.HashCode;
import com.google.common.io.Files;


import impl.DeltaResourceImpl;
import university.Book;
import university.Department;
import university.StaffMember;
import university.StaffMemberType;
import university.University;
import university.UniversityFactory;
import university.UniversityPackage;
import org.eclipse.epsilon.profiling.Stopwatch;

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
		
		//app.print();
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
				return new DeltaResourceImpl(uri,UniversityPackage.eINSTANCE);
			}
		});
		
		rs.getPackageRegistry().put(UniversityPackage.eINSTANCE.getNsURI(), 
				UniversityPackage.eINSTANCE);
		
		Resource resource = rs.createResource(URI.createFileURI(fileSaveLocation));
		resource.load(null);
		resource.load(null);
		
		//University uni1 = (University) resource.getContents().get(0);
		//uni1.setName("Leeds Uni");
		//resource.save(null);
	}
	

	
	public void createResource() throws Exception
	{
		//Resource res = new DeltaResourceImpl(URI.createURI(fileSaveLocation),UniversityPackage.eINSTANCE);
		
		Resource res = new XMIResourceImpl(URI.createURI("library.txt"));
		BinaryResourceImpl dfd;
		 Random rand = new Random();
		for(int i = 0; i < 1005000; i++)
		{
			University uni = UniversityFactory.eINSTANCE.createUniversity();
			res.getContents().add(uni);
			
			uni.setName(String.valueOf(rand.nextLong()));
			
			Book book = UniversityFactory.eINSTANCE.createBook();
			res.getContents().add(book);
			
			Department dep = UniversityFactory.eINSTANCE.createDepartment();
			uni.getDepartments().add(dep);
			dep.setName(String.valueOf(rand.nextInt()));
			
		}
		
		/*List<EObject> list = new ArrayList<EObject>();
		
		for(int i = 0; i <1000000; i++)
		{
			EObject obj = UniversityFactory.eINSTANCE.createLibrary();
			list.add(obj);
			
			obj = UniversityFactory.eINSTANCE.createModule();
			list.add(obj);
			
			obj = UniversityFactory.eINSTANCE.createStaffMember();
			list.add(obj);
		}
		
		res.getContents().addAll(list);*/
		
		res.save(null);
	}
	

	
	
}
