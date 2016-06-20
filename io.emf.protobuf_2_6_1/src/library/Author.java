/**
 */
package library;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link library.Author#getBooks <em>Books</em>}</li>
 * </ul>
 *
 * @see library.LibraryPackage#getAuthor()
 * @model
 * @generated
 */
public interface Author extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Books</b></em>' reference list.
	 * The list contents are of type {@link library.Book}.
	 * It is bidirectional and its opposite is '{@link library.Book#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Books</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Books</em>' reference list.
	 * @see library.LibraryPackage#getAuthor_Books()
	 * @see library.Book#getAuthor
	 * @model opposite="author" required="true"
	 * @generated
	 */
	EList<Book> getBooks();

} // Author
