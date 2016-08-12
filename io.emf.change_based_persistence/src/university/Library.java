/**
 */
package university;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link university.Library#getBooks <em>Books</em>}</li>
 *   <li>{@link university.Library#getLibraryVans <em>Library Vans</em>}</li>
 * </ul>
 *
 * @see university.UniversityPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link university.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see university.UniversityPackage#getLibrary_Books()
	 * @model containment="true"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * Returns the value of the '<em><b>Library Vans</b></em>' reference list.
	 * The list contents are of type {@link university.Vehicle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Vans</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library Vans</em>' reference list.
	 * @see university.UniversityPackage#getLibrary_LibraryVans()
	 * @model
	 * @generated
	 */
	EList<Vehicle> getLibraryVans();

} // Library
