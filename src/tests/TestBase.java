package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class TestBase {
	
	// intializing the property file reading

	public static Properties CONFIG=null;
	public static Properties OR=null;
	public static WebDriver dr = null;
	public static EventFiringWebDriver driver = null;
	public static boolean isLoggedIn = false;
	
	public void initialize() throws IOException {
	
		if(driver == null) {
		// config properties file
		CONFIG = new Properties();
		FileInputStream fn = new FileInputStream(System.getProperty("user.dir")+"//src//configs//config.properties");
		CONFIG.load(fn);
		
		//Object Repository properties file
		OR = new Properties();
		fn = new FileInputStream(System.getProperty("user.dir")+"//src//configs//OR.properties");
		OR.load(fn);
		
		// handling webdriver.gecko.driver property for firefox version above 48
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//configs//geckodriver.exe");
		
		// Initialize the webdriver and EvenFiringWebDriver
		if(CONFIG.getProperty("browser").equals("Firefox")) {
			dr = new FirefoxDriver();
		} else if(CONFIG.getProperty("browser").equals("IE")) {
			dr = new InternetExplorerDriver();
		}
		
		driver = new EventFiringWebDriver(dr);
		
		// Implicit wait for 30 seconds in the event of delay inloading the page
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Maximize the web browser window
		driver.manage().window().maximize();
		
		}
		
	}
	
	public static WebElement getObject(String xpathVal) {
		
		try {
				return driver.findElement(By.xpath(OR.getProperty(xpathVal)));
		} catch (Throwable t) {
			// report error if any xpath is not identified
			return null;
		}
		
	}
	
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
