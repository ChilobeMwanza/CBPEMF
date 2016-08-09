/**
 */
package library.impl;

import java.util.Collection;

import library.Book;
import library.Library;
import library.LibraryPackage;
import library.LibraryType;
import library.Vehicle;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
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
 *   <li>{@link library.impl.LibraryImpl#getSuperBook <em>Super Book</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getNumEmployees <em>Num Employees</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getADouble <em>ADouble</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getEmployeeNames <em>Employee Names</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getNumbersList <em>Numbers List</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getMainLibraryCar <em>Main Library Car</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getReserveLibraryCars <em>Reserve Library Cars</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getLibraryTypeAttrSingle <em>Library Type Attr Single</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getLibraryTypeAttrMany <em>Library Type Attr Many</em>}</li>
 *   <li>{@link library.impl.LibraryImpl#getLibraryTypeAttrTwo <em>Library Type Attr Two</em>}</li>
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
	 * The cached value of the '{@link #getSuperBook() <em>Super Book</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperBook()
	 * @generated
	 * @ordered
	 */
	protected Book superBook;

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
	 * The cached value of the '{@link #getMainLibraryCar() <em>Main Library Car</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMainLibraryCar()
	 * @generated
	 * @ordered
	 */
	protected Vehicle mainLibraryCar;

	/**
	 * The cached value of the '{@link #getReserveLibraryCars() <em>Reserve Library Cars</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReserveLibraryCars()
	 * @generated
	 * @ordered
	 */
	protected EList<Vehicle> reserveLibraryCars;

	/**
	 * The default value of the '{@link #getLibraryTypeAttrSingle() <em>Library Type Attr Single</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryTypeAttrSingle()
	 * @generated
	 * @ordered
	 */
	protected static final LibraryType LIBRARY_TYPE_ATTR_SINGLE_EDEFAULT = LibraryType.A;

	/**
	 * The cached value of the '{@link #getLibraryTypeAttrSingle() <em>Library Type Attr Single</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryTypeAttrSingle()
	 * @generated
	 * @ordered
	 */
	protected LibraryType libraryTypeAttrSingle = LIBRARY_TYPE_ATTR_SINGLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLibraryTypeAttrMany() <em>Library Type Attr Many</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryTypeAttrMany()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryType> libraryTypeAttrMany;

	/**
	 * The cached value of the '{@link #getLibraryTypeAttrTwo() <em>Library Type Attr Two</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryTypeAttrTwo()
	 * @generated
	 * @ordered
	 */
	protected EList<LibraryType> libraryTypeAttrTwo;

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
	public Book getSuperBook() {
		return superBook;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperBook(Book newSuperBook, NotificationChain msgs) {
		Book oldSuperBook = superBook;
		superBook = newSuperBook;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.LIBRARY__SUPER_BOOK, oldSuperBook, newSuperBook);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperBook(Book newSuperBook) {
		if (newSuperBook != superBook) {
			NotificationChain msgs = null;
			if (superBook != null)
				msgs = ((InternalEObject)superBook).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.LIBRARY__SUPER_BOOK, null, msgs);
			if (newSuperBook != null)
				msgs = ((InternalEObject)newSuperBook).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.LIBRARY__SUPER_BOOK, null, msgs);
			msgs = basicSetSuperBook(newSuperBook, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LIBRARY__SUPER_BOOK, newSuperBook, newSuperBook));
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
	public Vehicle getMainLibraryCar() {
		if (mainLibraryCar != null && mainLibraryCar.eIsProxy()) {
			InternalEObject oldMainLibraryCar = (InternalEObject)mainLibraryCar;
			mainLibraryCar = (Vehicle)eResolveProxy(oldMainLibraryCar);
			if (mainLibraryCar != oldMainLibraryCar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LibraryPackage.LIBRARY__MAIN_LIBRARY_CAR, oldMainLibraryCar, mainLibraryCar));
			}
		}
		return mainLibraryCar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle basicGetMainLibraryCar() {
		return mainLibraryCar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMainLibraryCar(Vehicle newMainLibraryCar) {
		Vehicle oldMainLibraryCar = mainLibraryCar;
		mainLibraryCar = newMainLibraryCar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LIBRARY__MAIN_LIBRARY_CAR, oldMainLibraryCar, mainLibraryCar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vehicle> getReserveLibraryCars() {
		if (reserveLibraryCars == null) {
			reserveLibraryCars = new EObjectResolvingEList<Vehicle>(Vehicle.class, this, LibraryPackage.LIBRARY__RESERVE_LIBRARY_CARS);
		}
		return reserveLibraryCars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryType getLibraryTypeAttrSingle() {
		return libraryTypeAttrSingle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLibraryTypeAttrSingle(LibraryType newLibraryTypeAttrSingle) {
		LibraryType oldLibraryTypeAttrSingle = libraryTypeAttrSingle;
		libraryTypeAttrSingle = newLibraryTypeAttrSingle == null ? LIBRARY_TYPE_ATTR_SINGLE_EDEFAULT : newLibraryTypeAttrSingle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_SINGLE, oldLibraryTypeAttrSingle, libraryTypeAttrSingle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LibraryType> getLibraryTypeAttrMany() {
		if (libraryTypeAttrMany == null) {
			libraryTypeAttrMany = new EDataTypeUniqueEList<LibraryType>(LibraryType.class, this, LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_MANY);
		}
		return libraryTypeAttrMany;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LibraryType> getLibraryTypeAttrTwo() {
		if (libraryTypeAttrTwo == null) {
			libraryTypeAttrTwo = new EDataTypeUniqueEList<LibraryType>(LibraryType.class, this, LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_TWO);
		}
		return libraryTypeAttrTwo;
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
			case LibraryPackage.LIBRARY__SUPER_BOOK:
				return basicSetSuperBook(null, msgs);
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
			case LibraryPackage.LIBRARY__SUPER_BOOK:
				return getSuperBook();
			case LibraryPackage.LIBRARY__NUM_EMPLOYEES:
				return getNumEmployees();
			case LibraryPackage.LIBRARY__ADOUBLE:
				return getADouble();
			case LibraryPackage.LIBRARY__EMPLOYEE_NAMES:
				return getEmployeeNames();
			case LibraryPackage.LIBRARY__NUMBERS_LIST:
				return getNumbersList();
			case LibraryPackage.LIBRARY__MAIN_LIBRARY_CAR:
				if (resolve) return getMainLibraryCar();
				return basicGetMainLibraryCar();
			case LibraryPackage.LIBRARY__RESERVE_LIBRARY_CARS:
				return getReserveLibraryCars();
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_SINGLE:
				return getLibraryTypeAttrSingle();
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_MANY:
				return getLibraryTypeAttrMany();
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_TWO:
				return getLibraryTypeAttrTwo();
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
			case LibraryPackage.LIBRARY__SUPER_BOOK:
				setSuperBook((Book)newValue);
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
			case LibraryPackage.LIBRARY__MAIN_LIBRARY_CAR:
				setMainLibraryCar((Vehicle)newValue);
				return;
			case LibraryPackage.LIBRARY__RESERVE_LIBRARY_CARS:
				getReserveLibraryCars().clear();
				getReserveLibraryCars().addAll((Collection<? extends Vehicle>)newValue);
				return;
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_SINGLE:
				setLibraryTypeAttrSingle((LibraryType)newValue);
				return;
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_MANY:
				getLibraryTypeAttrMany().clear();
				getLibraryTypeAttrMany().addAll((Collection<? extends LibraryType>)newValue);
				return;
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_TWO:
				getLibraryTypeAttrTwo().clear();
				getLibraryTypeAttrTwo().addAll((Collection<? extends LibraryType>)newValue);
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
			case LibraryPackage.LIBRARY__SUPER_BOOK:
				setSuperBook((Book)null);
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
			case LibraryPackage.LIBRARY__MAIN_LIBRARY_CAR:
				setMainLibraryCar((Vehicle)null);
				return;
			case LibraryPackage.LIBRARY__RESERVE_LIBRARY_CARS:
				getReserveLibraryCars().clear();
				return;
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_SINGLE:
				setLibraryTypeAttrSingle(LIBRARY_TYPE_ATTR_SINGLE_EDEFAULT);
				return;
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_MANY:
				getLibraryTypeAttrMany().clear();
				return;
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_TWO:
				getLibraryTypeAttrTwo().clear();
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
			case LibraryPackage.LIBRARY__SUPER_BOOK:
				return superBook != null;
			case LibraryPackage.LIBRARY__NUM_EMPLOYEES:
				return numEmployees != NUM_EMPLOYEES_EDEFAULT;
			case LibraryPackage.LIBRARY__ADOUBLE:
				return aDouble != ADOUBLE_EDEFAULT;
			case LibraryPackage.LIBRARY__EMPLOYEE_NAMES:
				return employeeNames != null && !employeeNames.isEmpty();
			case LibraryPackage.LIBRARY__NUMBERS_LIST:
				return numbersList != null && !numbersList.isEmpty();
			case LibraryPackage.LIBRARY__MAIN_LIBRARY_CAR:
				return mainLibraryCar != null;
			case LibraryPackage.LIBRARY__RESERVE_LIBRARY_CARS:
				return reserveLibraryCars != null && !reserveLibraryCars.isEmpty();
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_SINGLE:
				return libraryTypeAttrSingle != LIBRARY_TYPE_ATTR_SINGLE_EDEFAULT;
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_MANY:
				return libraryTypeAttrMany != null && !libraryTypeAttrMany.isEmpty();
			case LibraryPackage.LIBRARY__LIBRARY_TYPE_ATTR_TWO:
				return libraryTypeAttrTwo != null && !libraryTypeAttrTwo.isEmpty();
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
		result.append(", libraryTypeAttrSingle: ");
		result.append(libraryTypeAttrSingle);
		result.append(", libraryTypeAttrMany: ");
		result.append(libraryTypeAttrMany);
		result.append(", libraryTypeAttrTwo: ");
		result.append(libraryTypeAttrTwo);
		result.append(')');
		return result.toString();
	}

} //LibraryImpl
