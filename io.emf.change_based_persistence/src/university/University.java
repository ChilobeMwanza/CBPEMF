/**
 */
package university;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>University</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link university.University#getDepartments <em>Departments</em>}</li>
 *   <li>{@link university.University#getLibraries <em>Libraries</em>}</li>
 * </ul>
 *
 * @see university.UniversityPackage#getUniversity()
 * @model
 * @generated
 */
public interface University extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Departments</b></em>' containment reference list.
	 * The list contents are of type {@link university.Department}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Departments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Departments</em>' containment reference list.
	 * @see university.UniversityPackage#getUniversity_Departments()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Department> getDepartments();

	/**
	 * Returns the value of the '<em><b>Libraries</b></em>' containment reference list.
	 * The list contents are of type {@link university.Library}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Libraries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Libraries</em>' containment reference list.
	 * @see university.UniversityPackage#getUniversity_Libraries()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Library> getLibraries();

} // University