/**
 */
package university.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import university.Module;
import university.Student;
import university.UniversityPackage;
import university.Vehicle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Student</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link university.impl.StudentImpl#getEnrolledModules <em>Enrolled Modules</em>}</li>
 *   <li>{@link university.impl.StudentImpl#getRegisteredVehicle <em>Registered Vehicle</em>}</li>
 *   <li>{@link university.impl.StudentImpl#getStudentId <em>Student Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StudentImpl extends NamedElementImpl implements Student {
	/**
	 * The cached value of the '{@link #getEnrolledModules() <em>Enrolled Modules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnrolledModules()
	 * @generated
	 * @ordered
	 */
	protected EList<Module> enrolledModules;

	/**
	 * The cached value of the '{@link #getRegisteredVehicle() <em>Registered Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisteredVehicle()
	 * @generated
	 * @ordered
	 */
	protected Vehicle registeredVehicle;

	/**
	 * The default value of the '{@link #getStudentId() <em>Student Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStudentId()
	 * @generated
	 * @ordered
	 */
	protected static final double STUDENT_ID_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStudentId() <em>Student Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStudentId()
	 * @generated
	 * @ordered
	 */
	protected double studentId = STUDENT_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StudentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UniversityPackage.Literals.STUDENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Module> getEnrolledModules() {
		if (enrolledModules == null) {
			enrolledModules = new EObjectWithInverseResolvingEList.ManyInverse<Module>(Module.class, this, UniversityPackage.STUDENT__ENROLLED_MODULES, UniversityPackage.MODULE__ENROLLED_STUDENTS);
		}
		return enrolledModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle getRegisteredVehicle() {
		if (registeredVehicle != null && registeredVehicle.eIsProxy()) {
			InternalEObject oldRegisteredVehicle = (InternalEObject)registeredVehicle;
			registeredVehicle = (Vehicle)eResolveProxy(oldRegisteredVehicle);
			if (registeredVehicle != oldRegisteredVehicle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UniversityPackage.STUDENT__REGISTERED_VEHICLE, oldRegisteredVehicle, registeredVehicle));
			}
		}
		return registeredVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle basicGetRegisteredVehicle() {
		return registeredVehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegisteredVehicle(Vehicle newRegisteredVehicle) {
		Vehicle oldRegisteredVehicle = registeredVehicle;
		registeredVehicle = newRegisteredVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UniversityPackage.STUDENT__REGISTERED_VEHICLE, oldRegisteredVehicle, registeredVehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStudentId() {
		return studentId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStudentId(double newStudentId) {
		double oldStudentId = studentId;
		studentId = newStudentId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UniversityPackage.STUDENT__STUDENT_ID, oldStudentId, studentId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UniversityPackage.STUDENT__ENROLLED_MODULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEnrolledModules()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UniversityPackage.STUDENT__ENROLLED_MODULES:
				return ((InternalEList<?>)getEnrolledModules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UniversityPackage.STUDENT__ENROLLED_MODULES:
				return getEnrolledModules();
			case UniversityPackage.STUDENT__REGISTERED_VEHICLE:
				if (resolve) return getRegisteredVehicle();
				return basicGetRegisteredVehicle();
			case UniversityPackage.STUDENT__STUDENT_ID:
				return getStudentId();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UniversityPackage.STUDENT__ENROLLED_MODULES:
				getEnrolledModules().clear();
				getEnrolledModules().addAll((Collection<? extends Module>)newValue);
				return;
			case UniversityPackage.STUDENT__REGISTERED_VEHICLE:
				setRegisteredVehicle((Vehicle)newValue);
				return;
			case UniversityPackage.STUDENT__STUDENT_ID:
				setStudentId((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case UniversityPackage.STUDENT__ENROLLED_MODULES:
				getEnrolledModules().clear();
				return;
			case UniversityPackage.STUDENT__REGISTERED_VEHICLE:
				setRegisteredVehicle((Vehicle)null);
				return;
			case UniversityPackage.STUDENT__STUDENT_ID:
				setStudentId(STUDENT_ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UniversityPackage.STUDENT__ENROLLED_MODULES:
				return enrolledModules != null && !enrolledModules.isEmpty();
			case UniversityPackage.STUDENT__REGISTERED_VEHICLE:
				return registeredVehicle != null;
			case UniversityPackage.STUDENT__STUDENT_ID:
				return studentId != STUDENT_ID_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (studentId: ");
		result.append(studentId);
		result.append(')');
		return result.toString();
	}

} //StudentImpl
