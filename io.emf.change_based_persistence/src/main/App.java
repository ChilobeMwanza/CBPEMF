/**
 * TO DO,
 * 1)changelog optimisation algorithm.
 * 2)more tests for primitives, e.t.c
 * 3)more performance tuning,
 * 4)code cleanup
 */

package main;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.eclipse.emf.ecore.EEnum;
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

import impl.CBPBinaryResourceImpl;
import impl.CBPTextResourceImpl;
import university.Book;
import university.Department;
import university.PrimitiveType;
import university.StaffMember;
import university.StaffMemberType;
import university.Student;
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
		//app.createResource();
		
		
		//Integer x = new Integer(4);
	//	app.printNumber(x);
		//printNumber(x);
		
		
		/*PrimitiveType pt = UniversityFactory.eINSTANCE.createPrimitiveType();
		EAttribute attr = (EAttribute) pt.eClass().getEStructuralFeature("k");
		
		EDataType dt = attr.getEAttributeType();
		
		boolean b = false;
		
		Object obj = new Boolean(false);
		
		System.out.println(String.valueOf(obj));*/
		
		char c = 'd';
		
		String s = String.valueOf(c);
		
	
		
		
	}
	
	
	
	
	public void loadResource() throws IOException
	{
		ResourceSetImpl rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put
		("bin", new Resource.Factory()
		{
			@Override
			public Resource createResource(URI uri)
			{
				return new CBPBinaryResourceImpl(uri,UniversityPackage.eINSTANCE);
			}
		});
		
		rs.getPackageRegistry().put(UniversityPackage.eINSTANCE.getNsURI(), 
				UniversityPackage.eINSTANCE);
		
		Resource resource = rs.createResource(URI.createFileURI(fileSaveLocation));
		resource.load(null);
		resource.load(null);
		
		University uni1 = (University) resource.getContents().get(0);
		uni1.setName("Leeds Uni");
		
		//resource.save(null);
	}
	

	
	public void createResource() throws Exception
	{
		Resource res = new 
				CBPTextResourceImpl(URI.createURI(fileSaveLocation),UniversityPackage.eINSTANCE);
		
		Book book = UniversityFactory.eINSTANCE.createBook();
		
		res.getContents().add(book);
		
		book.getAuthorNames().add("a");
		book.getAuthorNames().add(null);
		book.getAuthorNames().add("C");
		
		book.getAuthorNames().remove(null);
		
		
		
		//res.getContents().add(uni);
		
		//uni.setName("York Uni");
		//uni.setName(null);
		
		


	
		res.save(null);
		
		
		//s1.setStaffMemberType(null);
		
	}
	

	
	
}
