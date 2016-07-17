/**
 */
package library;

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
 *   <li>{@link library.Library#getBooks <em>Books</em>}</li>
 *   <li>{@link library.Library#getNumEmployees <em>Num Employees</em>}</li>
 *   <li>{@link library.Library#getADouble <em>ADouble</em>}</li>
 *   <li>{@link library.Library#getEmployeeNames <em>Employee Names</em>}</li>
 *   <li>{@link library.Library#getNumbersList <em>Numbers List</em>}</li>
 * </ul>
 *
 * @see library.LibraryPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Books</b></em>' containment reference list.
	 * The list contents are of type {@link library.Book}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' containment reference list.
	 * @see library.LibraryPackage#getLibrary_Books()
	 * @model containment="true"
	 * @generated
	 */
	EList<Book> getBooks();

	/**
	 * Returns the value of the '<em><b>Num Employees</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Employees</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Employees</em>' attribute.
	 * @see #setNumEmployees(int)
	 * @see library.LibraryPackage#getLibrary_NumEmployees()
	 * @model
	 * @generated
	 */
	int getNumEmployees();

	/**
	 * Sets the value of the '{@link library.Library#getNumEmployees <em>Num Employees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Employees</em>' attribute.
	 * @see #getNumEmployees()
	 * @generated
	 */
	void setNumEmployees(int value);

	/**
	 * Returns the value of the '<em><b>ADouble</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ADouble</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ADouble</em>' attribute.
	 * @see #setADouble(double)
	 * @see library.LibraryPackage#getLibrary_ADouble()
	 * @model
	 * @generated
	 */
	double getADouble();

	/**
	 * Sets the value of the '{@link library.Library#getADouble <em>ADouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ADouble</em>' attribute.
	 * @see #getADouble()
	 * @generated
	 */
	void setADouble(double value);

	/**
	 * Returns the value of the '<em><b>Employee Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Employee Names</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Employee Names</em>' attribute list.
	 * @see library.LibraryPackage#getLibrary_EmployeeNames()
	 * @model
	 * @generated
	 */
	EList<String> getEmployeeNames();

	/**
	 * Returns the value of the '<em><b>Numbers List</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numbers List</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numbers List</em>' attribute list.
	 * @see library.LibraryPackage#getLibrary_NumbersList()
	 * @model
	 * @generated
	 */
	EList<Integer> getNumbersList();

} // Library
