/*
 * Explicitly tests methods not implicitly tested by other test cases
 */
package generated_emf_tests;
import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import impl.CBPTextResourceImpl;
public class DeltaResouceImplTests extends TestBase 
{
	@Test
	public void testGetChangelog()
	{
		CBPTextResourceImpl res = new CBPTextResourceImpl(URI.createURI(fileSaveLocation),ePackage);
		assertNotNull(res.getChangelog());
	}
}
