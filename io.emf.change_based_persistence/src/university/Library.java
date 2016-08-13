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
 *   <li>{@link university.Library#getMainComputer <em>Main Computer</em>}</li>
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
	 * Returns the value of the '<em><b>Main Computer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Main Computer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Main Computer</em>' containment reference.
	 * @see #setMainComputer(Computer)
	 * @see university.UniversityPackage#getLibrary_MainComputer()
	 * @model containment="true"
	 * @generated
	 */
	Computer getMainComputer();

	/**
	 * Sets the value of the '{@link university.Library#getMainComputer <em>Main Computer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main Computer</em>' containment reference.
	 * @see #getMainComputer()
	 * @generated
	 */
	void setMainComputer(Computer value);

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
