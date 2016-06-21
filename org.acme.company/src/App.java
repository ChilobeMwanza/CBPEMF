import java.io.File;
import java.io.FileOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import company.Company;
import company.CompanyFactory;
import company.CompanyPackage;
import company.Employee;


public class App {
	
	public static void main(String[] args) throws Exception {
		new App().loadResource();
	}
	
	public void createResource() throws Exception {
		
		Resource resource = new XMIResourceImpl();
		
		Company c = CompanyFactory.eINSTANCE.createCompany();
		c.setName("ACME");
		
		Employee tom = CompanyFactory.eINSTANCE.createEmployee();
		tom.setFullName("Tom Jone");
		
		c.getEmployees().add(tom);
		
		resource.getContents().add(c);
		
		resource.save(new FileOutputStream(new File("acme.xmi")), null);		
	}
	
	public void loadResource() throws Exception {
		
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(CompanyPackage.eINSTANCE.getNsURI(), CompanyPackage.eINSTANCE);
		Resource resource = rs.createResource(URI.createFileURI("/Users/dkolovos/Projects/Eclipse/eclipse-modeling-luna/workspace/org.acme.company/acme.xmi"));
		resource.load(null);
		
		Company c = (Company) resource.getContents().get(0);
		
		for (Employee e : c.getEmployees()) {
			System.out.println(e.getFullName());
		}
		
	}
	
}
