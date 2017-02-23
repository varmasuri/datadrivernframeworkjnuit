package util;

import org.openqa.selenium.By;

import tests.TestBase;

public class TestUtil extends TestBase {
	
	public static void doLogin(String username, String password) {
		
		if(isLoggedIn) {
			return;
		}
		
		getObject("signin_link").click();
		getObject("username_email").sendKeys(username);
		getObject("password").sendKeys(password);
		getObject("login_button").click();
		
		//check wther any login error message is being displayed
		
		try {
		String displayedUsername = driver.findElement(By.xpath(OR.getProperty("username_top_link"))).getText();
		
		if(displayedUsername.equals(username)) {
			isLoggedIn = true;
		} else {
			isLoggedIn = false;
			}
		}catch (Throwable t) {
			
		}
		
	}

}
