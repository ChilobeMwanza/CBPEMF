/**
 */
package library.impl;

import java.util.Collection;

import library.LibraryPackage;
import library.Module;
import library.Student;
import library.Vehicle;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Student</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link library.impl.StudentImpl#getRegisteredModules <em>Registered Modules</em>}</li>
 *   <li>{@link library.impl.StudentImpl#getRegisteredCar <em>Registered Car</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StudentImpl extends NamedElementImpl implements Student {
	/**
	 * The cached value of the '{@link #getRegisteredModules() <em>Registered Modules</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisteredModules()
	 * @generated
	 * @ordered
	 */
	protected EList<Module> registeredModules;

	/**
	 * The cached value of the '{@link #getRegisteredCar() <em>Registered Car</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegisteredCar()
	 * @generated
	 * @ordered
	 */
	protected Vehicle registeredCar;

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
		return LibraryPackage.Literals.STUDENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Module> getRegisteredModules() {
		if (registeredModules == null) {
			registeredModules = new EObjectWithInverseResolvingEList.ManyInverse<Module>(Module.class, this, LibraryPackage.STUDENT__REGISTERED_MODULES, LibraryPackage.MODULE__REGISTERED_STUDENTS);
		}
		return registeredModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle getRegisteredCar() {
		return registeredCar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRegisteredCar(Vehicle newRegisteredCar, NotificationChain msgs) {
		Vehicle oldRegisteredCar = registeredCar;
		registeredCar = newRegisteredCar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.STUDENT__REGISTERED_CAR, oldRegisteredCar, newRegisteredCar);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegisteredCar(Vehicle newRegisteredCar) {
		if (newRegisteredCar != registeredCar) {
			NotificationChain msgs = null;
			if (registeredCar != null)
				msgs = ((InternalEObject)registeredCar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.STUDENT__REGISTERED_CAR, null, msgs);
			if (newRegisteredCar != null)
				msgs = ((InternalEObject)newRegisteredCar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.STUDENT__REGISTERED_CAR, null, msgs);
			msgs = basicSetRegisteredCar(newRegisteredCar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.STUDENT__REGISTERED_CAR, newRegisteredCar, newRegisteredCar));
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
			case LibraryPackage.STUDENT__REGISTERED_MODULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRegisteredModules()).basicAdd(otherEnd, msgs);
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
			case LibraryPackage.STUDENT__REGISTERED_MODULES:
				return ((InternalEList<?>)getRegisteredModules()).basicRemove(otherEnd, msgs);
			case LibraryPackage.STUDENT__REGISTERED_CAR:
				return basicSetRegisteredCar(null, msgs);
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
			case LibraryPackage.STUDENT__REGISTERED_MODULES:
				return getRegisteredModules();
			case LibraryPackage.STUDENT__REGISTERED_CAR:
				return getRegisteredCar();
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
			case LibraryPackage.STUDENT__REGISTERED_MODULES:
				getRegisteredModules().clear();
				getRegisteredModules().addAll((Collection<? extends Module>)newValue);
				return;
			case LibraryPackage.STUDENT__REGISTERED_CAR:
				setRegisteredCar((Vehicle)newValue);
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
			case LibraryPackage.STUDENT__REGISTERED_MODULES:
				getRegisteredModules().clear();
				return;
			case LibraryPackage.STUDENT__REGISTERED_CAR:
				setRegisteredCar((Vehicle)null);
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
			case LibraryPackage.STUDENT__REGISTERED_MODULES:
				return registeredModules != null && !registeredModules.isEmpty();
			case LibraryPackage.STUDENT__REGISTERED_CAR:
				return registeredCar != null;
		}
		return super.eIsSet(featureID);
	}

} //StudentImpl
