/**
 */
package university;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Staff Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link university.StaffMember#getStaffMemberType <em>Staff Member Type</em>}</li>
 *   <li>{@link university.StaffMember#getTaughtModules <em>Taught Modules</em>}</li>
 *   <li>{@link university.StaffMember#getRegisteredVehicles <em>Registered Vehicles</em>}</li>
 * </ul>
 *
 * @see university.UniversityPackage#getStaffMember()
 * @model
 * @generated
 */
public interface StaffMember extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Staff Member Type</b></em>' attribute.
	 * The literals are from the enumeration {@link university.StaffMemberType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Staff Member Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Staff Member Type</em>' attribute.
	 * @see university.StaffMemberType
	 * @see #setStaffMemberType(StaffMemberType)
	 * @see university.UniversityPackage#getStaffMember_StaffMemberType()
	 * @model
	 * @generated
	 */
	StaffMemberType getStaffMemberType();

	/**
	 * Sets the value of the '{@link university.StaffMember#getStaffMemberType <em>Staff Member Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Staff Member Type</em>' attribute.
	 * @see university.StaffMemberType
	 * @see #getStaffMemberType()
	 * @generated
	 */
	void setStaffMemberType(StaffMemberType value);

	/**
	 * Returns the value of the '<em><b>Taught Modules</b></em>' reference list.
	 * The list contents are of type {@link university.Module}.
	 * It is bidirectional and its opposite is '{@link university.Module#getModuleLecturers <em>Module Lecturers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Taught Modules</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Taught Modules</em>' reference list.
	 * @see university.UniversityPackage#getStaffMember_TaughtModules()
	 * @see university.Module#getModuleLecturers
	 * @model opposite="moduleLecturers"
	 * @generated
	 */
	EList<Module> getTaughtModules();

	/**
	 * Returns the value of the '<em><b>Registered Vehicles</b></em>' reference list.
	 * The list contents are of type {@link university.Vehicle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registered Vehicles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registered Vehicles</em>' reference list.
	 * @see university.UniversityPackage#getStaffMember_RegisteredVehicles()
	 * @model upper="3"
	 * @generated
	 */
	EList<Vehicle> getRegisteredVehicles();

} // StaffMember
