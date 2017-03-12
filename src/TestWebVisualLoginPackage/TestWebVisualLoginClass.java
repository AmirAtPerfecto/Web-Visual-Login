package TestWebVisualLoginPackage;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class TestWebVisualLoginClass {
	RemoteWebDriver driver;

	// Create Remote WebDriver based on testng.xml configuration
	@Parameters({ "platformName", "platformVersion", "browserName", "browserVersion", "screenResolution" })
	@BeforeTest
	public void beforeTest(String platformName, String platformVersion, String browserName, String browserVersion, String screenResolution) throws MalformedURLException {
		driver = Utils.getRemoteWebDriver(platformName, platformVersion, browserName, browserVersion, screenResolution);        
	} 

	@Test 
	public void testLogin() {
		driver.get("http://nxc.co.il/ntlm.php");
		// Validate we're on the right page
		PerfectoUtils.ocrTextCheck(driver, "Authentication", 99, 10);
		// enter the credentials
		VisualHandle.enterCredentials(driver, System.getenv("TEST_PAGE_LOGIN_USERNAME"), System.getenv("TEST_PAGE_LOGIN_PASSWORD"));
		// Click login
		PerfectoUtils.ocrTextClick(driver, "Log In", 99, 30);
		// validate we're logged in
		PerfectoUtils.ocrTextCheck(driver, "You Are", 99, 10);
		// dismiss the 2nd popup
		PerfectoUtils.ocrTextClick(driver, "Never", 99, 30);
	}
	@AfterTest
	public void afterTest() throws IOException {
		String reportURL = (String)driver.getCapabilities().getCapability("testGridReportUrl");
		System.out.println("########### ========>>>>>>>> Report URL: "+ reportURL); 
		// Abort test in case of an unexpected error.
		driver.close();
		driver.quit();	

	}	

}
