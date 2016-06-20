/**
 */
package library;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Employee Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see library.LibraryPackage#getEmployeeType()
 * @model
 * @generated
 */
public enum EmployeeType implements Enumerator {
	/**
	 * The '<em><b>Temp</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMP_VALUE
	 * @generated
	 * @ordered
	 */
	TEMP(0, "temp", "temp"),

	/**
	 * The '<em><b>Permananent</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PERMANANENT_VALUE
	 * @generated
	 * @ordered
	 */
	PERMANANENT(1, "permananent", "permananent"),

	/**
	 * The '<em><b>Contract</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTRACT_VALUE
	 * @generated
	 * @ordered
	 */
	CONTRACT(2, "contract", "contract");

	/**
	 * The '<em><b>Temp</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Temp</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEMP
	 * @model name="temp"
	 * @generated
	 * @ordered
	 */
	public static final int TEMP_VALUE = 0;

	/**
	 * The '<em><b>Permananent</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Permananent</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PERMANANENT
	 * @model name="permananent"
	 * @generated
	 * @ordered
	 */
	public static final int PERMANANENT_VALUE = 1;

	/**
	 * The '<em><b>Contract</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Contract</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CONTRACT
	 * @model name="contract"
	 * @generated
	 * @ordered
	 */
	public static final int CONTRACT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Employee Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EmployeeType[] VALUES_ARRAY =
		new EmployeeType[] {
			TEMP,
			PERMANANENT,
			CONTRACT,
		};

	/**
	 * A public read-only list of all the '<em><b>Employee Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EmployeeType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Employee Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EmployeeType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmployeeType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Employee Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EmployeeType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmployeeType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Employee Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EmployeeType get(int value) {
		switch (value) {
			case TEMP_VALUE: return TEMP;
			case PERMANANENT_VALUE: return PERMANANENT;
			case CONTRACT_VALUE: return CONTRACT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EmployeeType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EmployeeType
