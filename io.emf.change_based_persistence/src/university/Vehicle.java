/**
 */
package university;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link university.Vehicle#getRegistrationNumber <em>Registration Number</em>}</li>
 * </ul>
 *
 * @see university.UniversityPackage#getVehicle()
 * @model
 * @generated
 */
public interface Vehicle extends EObject {
	/**
	 * Returns the value of the '<em><b>Registration Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Registration Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Registration Number</em>' attribute.
	 * @see #setRegistrationNumber(String)
	 * @see university.UniversityPackage#getVehicle_RegistrationNumber()
	 * @model
	 * @generated
	 */
	String getRegistrationNumber();

	/**
	 * Sets the value of the '{@link university.Vehicle#getRegistrationNumber <em>Registration Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Registration Number</em>' attribute.
	 * @see #getRegistrationNumber()
	 * @generated
	 */
	void setRegistrationNumber(String value);

} // Vehicle
