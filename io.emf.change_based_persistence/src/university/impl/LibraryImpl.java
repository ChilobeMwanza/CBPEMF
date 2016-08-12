/**
 */
package university.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import university.Book;
import university.Library;
import university.UniversityPackage;
import university.Vehicle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link university.impl.LibraryImpl#getBooks <em>Books</em>}</li>
 *   <li>{@link university.impl.LibraryImpl#getLibraryVans <em>Library Vans</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LibraryImpl extends NamedElementImpl implements Library {
	/**
	 * The cached value of the '{@link #getBooks() <em>Books</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooks()
	 * @generated
	 * @ordered
	 */
	protected EList<Book> books;

	/**
	 * The cached value of the '{@link #getLibraryVans() <em>Library Vans</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryVans()
	 * @generated
	 * @ordered
	 */
	protected EList<Vehicle> libraryVans;

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
		return UniversityPackage.Literals.LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Book> getBooks() {
		if (books == null) {
			books = new EObjectContainmentEList<Book>(Book.class, this, UniversityPackage.LIBRARY__BOOKS);
		}
		return books;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vehicle> getLibraryVans() {
		if (libraryVans == null) {
			libraryVans = new EObjectResolvingEList<Vehicle>(Vehicle.class, this, UniversityPackage.LIBRARY__LIBRARY_VANS);
		}
		return libraryVans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UniversityPackage.LIBRARY__BOOKS:
				return ((InternalEList<?>)getBooks()).basicRemove(otherEnd, msgs);
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
			case UniversityPackage.LIBRARY__BOOKS:
				return getBooks();
			case UniversityPackage.LIBRARY__LIBRARY_VANS:
				return getLibraryVans();
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
			case UniversityPackage.LIBRARY__BOOKS:
				getBooks().clear();
				getBooks().addAll((Collection<? extends Book>)newValue);
				return;
			case UniversityPackage.LIBRARY__LIBRARY_VANS:
				getLibraryVans().clear();
				getLibraryVans().addAll((Collection<? extends Vehicle>)newValue);
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
			case UniversityPackage.LIBRARY__BOOKS:
				getBooks().clear();
				return;
			case UniversityPackage.LIBRARY__LIBRARY_VANS:
				getLibraryVans().clear();
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
			case UniversityPackage.LIBRARY__BOOKS:
				return books != null && !books.isEmpty();
			case UniversityPackage.LIBRARY__LIBRARY_VANS:
				return libraryVans != null && !libraryVans.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LibraryImpl
