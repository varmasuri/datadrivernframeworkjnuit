package tests;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import util.TestUtil;

public class LoginTest extends TestBase{
	
	@Before
	public void beforeTest() throws IOException {
		initialize();
	}
	
	@Test
	public void loginTest() {
		driver.get(CONFIG.getProperty("testSiteName"));
		TestUtil.doLogin("varma435@gmail.com", "Test@435");
		
		if(!isLoggedIn) {
			// reporterror
		}
	}

}
