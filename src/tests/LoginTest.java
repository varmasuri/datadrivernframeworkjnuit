package tests;

import java.io.IOException;

import org.junit.After;
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
		TestUtil.doLogin("radhi.kr@gmail.com", "Radhi@8153");
		
		if(!isLoggedIn) {
			// reporterror
		}
	}
	
	@After
	public void afterTest() {
		tearDown();
		
	}

}
