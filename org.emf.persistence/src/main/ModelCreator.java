/**
 * Contains the code for creating model elements e.t.c, helps to avoid code duplication between the XMIPersistence and BinaryPersistence classes
 */
package main;

import org.eclipse.emf.ecore.resource.Resource;

import library.Author;
import library.Book;
import library.Employee;
import library.EmployeeType;
import library.Library;
import library.LibraryFactory;

public abstract class ModelCreator 
{
	/**
	 * Creates and returns library model (and all its associated elements).
	 * @return Library model.
	 */
	protected Library createLibraryModel(Resource res)
	{
		Library lib = LibraryFactory.eINSTANCE.createLibrary();
		
		/*Create some authors */
		Author[] authorsArray = new Author[3];
		
	    authorsArray[0]= createAuthor("Dan Brown");
	    authorsArray[1]= createAuthor("J K Rowling");
	    authorsArray[2] = createAuthor("Stephen Hawking");
		
		/*Create some books, associate authors to books*/
		Book[] booksArray = new Book[6];
		booksArray[0] = createBook("Harry Potter and the ISM",1.0,authorsArray[0]);
		booksArray[1]  = createBook("Harry Potter and the MODE",1.2,authorsArray[0]);
		booksArray[2]  = createBook("A super good day",0.45,authorsArray[1]);
		booksArray[3] = createBook("Hello World in Mode",0.54, authorsArray[2]);
		booksArray[4] = createBook("Hello World in Java",0.54, authorsArray[2]);
		booksArray[5] = createBook("Hello World in C++",0.54, authorsArray[2]);
		
		/*Create some employees*/
		Employee[] employeesArray = new Employee[4];
		employeesArray[0] = createEmployee("James White", EmployeeType.CONTRACT);
		employeesArray[1]  = createEmployee("Peter Green", EmployeeType.CONTRACT);
		employeesArray[2] = createEmployee("Joseph  Yellow", EmployeeType.PERMANANENT);
		employeesArray[3]  = createEmployee("Robert Black", EmployeeType.TEMP);
		
		/*Add authors to resource*/
		for(Author author : authorsArray)
		{
			//all model elements must be added to resource either directly (like this) or indirectly see createResource, ask about this!!
			res.getContents().add(author); 
		}
		/*Add the employees to the library*/
		for(Employee employee : employeesArray)
		{
			lib.getEmployees().add(employee);
		}
		
		/* Add the books to the library*/
		for(Book book : booksArray)
		{
			lib.getBooks().add(book);	
		}
		
		return lib;
	}
	
	private Book createBook(String name, double id, Author author)
	{
		Book book = LibraryFactory.eINSTANCE.createBook();
		book.setName(name);
		book.setIdNumber(id);
		book.setAuthor(author);
		
		return book;
	}
	
	private Author createAuthor(String name)
	{
		Author author = LibraryFactory.eINSTANCE.createAuthor();
		author.setName(name);
		
		return author;
	}
	
	private Employee createEmployee(String name, EmployeeType employeeType)
	{
		Employee employee = LibraryFactory.eINSTANCE.createEmployee();
		employee.setName(name);
		employee.setEmployeeType(employeeType);
		
		return employee;
	}
}
