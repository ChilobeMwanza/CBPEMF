/**
 */
package library.impl;

import java.util.Collection;

import library.Book;
import library.Library;
import library.LibraryPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link library.impl.LibraryImpl#getGoodBooks <em>Good Books</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getBadBooks <em>Bad Books</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getNumEmployees <em>Num Employees</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getADouble <em>ADouble</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getEmployeeNames <em>Employee Names</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getNumbersList <em>Numbers List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LibraryImpl extends NamedElementImpl implements Library {
	/**
	 * The cached value of the '{@link #getGoodBooks() <em>Good Books</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoodBooks()
	 * @generated
	 * @ordered
	 */
	protected EList<Book> goodBooks;

	/**
	 * The cached value of the '{@link #getBadBooks() <em>Bad Books</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBadBooks()
	 * @generated
	 * @ordered
	 */
	protected EList<Book> badBooks;

	/**
	 * The default value of the '{@link #getNumEmployees() <em>Num Employees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumEmployees()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_EMPLOYEES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumEmployees() <em>Num Employees</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumEmployees()
	 * @generated
	 * @ordered
	 */
	protected int numEmployees = NUM_EMPLOYEES_EDEFAULT;

	/**
	 * The default value of the '{@link #getADouble() <em>ADouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getADouble()
	 * @generated
	 * @ordered
	 */
	protected static final double ADOUBLE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getADouble() <em>ADouble</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getADouble()
	 * @generated
	 * @ordered
	 */
	protected double aDouble = ADOUBLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEmployeeNames() <em>Employee Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmployeeNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> employeeNames;

	/**
	 * The cached value of the '{@link #getNumbersList() <em>Numbers List</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumbersList()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> numbersList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Book> getGoodBooks() {
		if (goodBooks == null) {
			goodBooks = new EObjectContainmentEList<Book>(Book.class, this, LibraryPackage.LIBRARY__GOOD_BOOKS);
		}
		return goodBooks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Book> getBadBooks() {
		if (badBooks == null) {
			badBooks = new EObjectContainmentEList<Book>(Book.class, this, LibraryPackage.LIBRARY__BAD_BOOKS);
		}
		return badBooks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumEmployees() {
		return numEmployees;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumEmployees(int newNumEmployees) {
		int oldNumEmployees = numEmployees;
		numEmployees = newNumEmployees;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LIBRARY__NUM_EMPLOYEES, oldNumEmployees, numEmployees));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getADouble() {
		return aDouble;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setADouble(double newADouble) {
		double oldADouble = aDouble;
		aDouble = newADouble;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LIBRARY__ADOUBLE, oldADouble, aDouble));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getEmployeeNames() {
		if (employeeNames == null) {
			employeeNames = new EDataTypeUniqueEList<String>(String.class, this, LibraryPackage.LIBRARY__EMPLOYEE_NAMES);
		}
		return employeeNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Integer> getNumbersList() {
		if (numbersList == null) {
			numbersList = new EDataTypeUniqueEList<Integer>(Integer.class, this, LibraryPackage.LIBRARY__NUMBERS_LIST);
		}
		return numbersList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.LIBRARY__GOOD_BOOKS:
				return ((InternalEList<?>)getGoodBooks()).basicRemove(otherEnd, msgs);
			case LibraryPackage.LIBRARY__BAD_BOOKS:
				return ((InternalEList<?>)getBadBooks()).basicRemove(otherEnd, msgs);
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
			case LibraryPackage.LIBRARY__GOOD_BOOKS:
				return getGoodBooks();
			case LibraryPackage.LIBRARY__BAD_BOOKS:
				return getBadBooks();
			case LibraryPackage.LIBRARY__NUM_EMPLOYEES:
				return getNumEmployees();
			case LibraryPackage.LIBRARY__ADOUBLE:
				return getADouble();
			case LibraryPackage.LIBRARY__EMPLOYEE_NAMES:
				return getEmployeeNames();
			case LibraryPackage.LIBRARY__NUMBERS_LIST:
				return getNumbersList();
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
			case LibraryPackage.LIBRARY__GOOD_BOOKS:
				getGoodBooks().clear();
				getGoodBooks().addAll((Collection<? extends Book>)newValue);
				return;
			case LibraryPackage.LIBRARY__BAD_BOOKS:
				getBadBooks().clear();
				getBadBooks().addAll((Collection<? extends Book>)newValue);
				return;
			case LibraryPackage.LIBRARY__NUM_EMPLOYEES:
				setNumEmployees((Integer)newValue);
				return;
			case LibraryPackage.LIBRARY__ADOUBLE:
				setADouble((Double)newValue);
				return;
			case LibraryPackage.LIBRARY__EMPLOYEE_NAMES:
				getEmployeeNames().clear();
				getEmployeeNames().addAll((Collection<? extends String>)newValue);
				return;
			case LibraryPackage.LIBRARY__NUMBERS_LIST:
				getNumbersList().clear();
				getNumbersList().addAll((Collection<? extends Integer>)newValue);
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
			case LibraryPackage.LIBRARY__GOOD_BOOKS:
				getGoodBooks().clear();
				return;
			case LibraryPackage.LIBRARY__BAD_BOOKS:
				getBadBooks().clear();
				return;
			case LibraryPackage.LIBRARY__NUM_EMPLOYEES:
				setNumEmployees(NUM_EMPLOYEES_EDEFAULT);
				return;
			case LibraryPackage.LIBRARY__ADOUBLE:
				setADouble(ADOUBLE_EDEFAULT);
				return;
			case LibraryPackage.LIBRARY__EMPLOYEE_NAMES:
				getEmployeeNames().clear();
				return;
			case LibraryPackage.LIBRARY__NUMBERS_LIST:
				getNumbersList().clear();
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
			case LibraryPackage.LIBRARY__GOOD_BOOKS:
				return goodBooks != null && !goodBooks.isEmpty();
			case LibraryPackage.LIBRARY__BAD_BOOKS:
				return badBooks != null && !badBooks.isEmpty();
			case LibraryPackage.LIBRARY__NUM_EMPLOYEES:
				return numEmployees != NUM_EMPLOYEES_EDEFAULT;
			case LibraryPackage.LIBRARY__ADOUBLE:
				return aDouble != ADOUBLE_EDEFAULT;
			case LibraryPackage.LIBRARY__EMPLOYEE_NAMES:
				return employeeNames != null && !employeeNames.isEmpty();
			case LibraryPackage.LIBRARY__NUMBERS_LIST:
				return numbersList != null && !numbersList.isEmpty();
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
		result.append(" (numEmployees: ");
		result.append(numEmployees);
		result.append(", aDouble: ");
		result.append(aDouble);
		result.append(", employeeNames: ");
		result.append(employeeNames);
		result.append(", numbersList: ");
		result.append(numbersList);
		result.append(')');
		return result.toString();
	}

} //LibraryImpl
