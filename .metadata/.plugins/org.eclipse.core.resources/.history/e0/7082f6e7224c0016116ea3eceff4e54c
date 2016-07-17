/**
 */
package library.impl;

import library.Author;
import library.Book;
import library.LibraryPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link library.impl.BookImpl#getIdNumber <em>Id Number</em>}</li>
 *   <li>{@link library.impl.BookImpl#getAnAuthor <em>An Author</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BookImpl extends NamedElementImpl implements Book {
	/**
	 * The default value of the '{@link #getIdNumber() <em>Id Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdNumber()
	 * @generated
	 * @ordered
	 */
	protected static final double ID_NUMBER_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getIdNumber() <em>Id Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdNumber()
	 * @generated
	 * @ordered
	 */
	protected double idNumber = ID_NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAnAuthor() <em>An Author</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnAuthor()
	 * @generated
	 * @ordered
	 */
	protected Author anAuthor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BookImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.BOOK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getIdNumber() {
		return idNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdNumber(double newIdNumber) {
		double oldIdNumber = idNumber;
		idNumber = newIdNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BOOK__ID_NUMBER, oldIdNumber, idNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Author getAnAuthor() {
		return anAuthor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnAuthor(Author newAnAuthor, NotificationChain msgs) {
		Author oldAnAuthor = anAuthor;
		anAuthor = newAnAuthor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LibraryPackage.BOOK__AN_AUTHOR, oldAnAuthor, newAnAuthor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnAuthor(Author newAnAuthor) {
		if (newAnAuthor != anAuthor) {
			NotificationChain msgs = null;
			if (anAuthor != null)
				msgs = ((InternalEObject)anAuthor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.BOOK__AN_AUTHOR, null, msgs);
			if (newAnAuthor != null)
				msgs = ((InternalEObject)newAnAuthor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LibraryPackage.BOOK__AN_AUTHOR, null, msgs);
			msgs = basicSetAnAuthor(newAnAuthor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.BOOK__AN_AUTHOR, newAnAuthor, newAnAuthor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LibraryPackage.BOOK__AN_AUTHOR:
				return basicSetAnAuthor(null, msgs);
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
			case LibraryPackage.BOOK__ID_NUMBER:
				return getIdNumber();
			case LibraryPackage.BOOK__AN_AUTHOR:
				return getAnAuthor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LibraryPackage.BOOK__ID_NUMBER:
				setIdNumber((Double)newValue);
				return;
			case LibraryPackage.BOOK__AN_AUTHOR:
				setAnAuthor((Author)newValue);
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
			case LibraryPackage.BOOK__ID_NUMBER:
				setIdNumber(ID_NUMBER_EDEFAULT);
				return;
			case LibraryPackage.BOOK__AN_AUTHOR:
				setAnAuthor((Author)null);
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
			case LibraryPackage.BOOK__ID_NUMBER:
				return idNumber != ID_NUMBER_EDEFAULT;
			case LibraryPackage.BOOK__AN_AUTHOR:
				return anAuthor != null;
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
		result.append(" (idNumber: ");
		result.append(idNumber);
		result.append(')');
		return result.toString();
	}

} //BookImpl
