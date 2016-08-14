package exceptions;

public class UnknownPackageException extends Exception
{
	public UnknownPackageException(String nsURI)
	{
		super("The package with nsURI: "+nsURI+" could not be found within the"
				+ " global EPackage registry. Did you register it?");
	}
}
