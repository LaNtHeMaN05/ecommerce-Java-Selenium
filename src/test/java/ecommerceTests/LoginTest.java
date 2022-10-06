package ecommerceTests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class LoginTest extends BaseClass{
	public WebDriver driver;
	
	Logger log=LogManager.getLogger(LoginTest.class.getName());
	

	@BeforeTest
	public void initializeWebDriver() throws IOException {
		log.info("*****************Login Test - Started****************");
		driver=webDriverStart();
		log.info("Driver Initalized Successfully");
		driver.get(testURL);
		log.info("Test URL loaded Successfully");
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		HomePage hp=new HomePage(driver);		
		hp.clickLogin().click();
		log.info("Login Button clicked from HomePage");
		LoginPage lp=new LoginPage(driver);
		lp.emailEnter().sendKeys(wrong_id);
		lp.passwordEnter().sendKeys(pswd);
		lp.signClick().click();
		log.info("Checking Wrong Creds Successfully");
		String authMsg=lp.AuthMsg().getText();
		
		//Wrong Auth msg Check
		
		Assert.assertEquals("Authentication failed.", authMsg);
		
		lp.emailEnter().clear();
		lp.emailEnter().sendKeys(correct_id);
		lp.passwordEnter().clear();
		lp.passwordEnter().sendKeys(pswd);
		lp.signClick().click();
		log.info("Login Passed Successfully");
		//Successful Login
		
		String logoutCheck=lp.LogoutBtn().getText();
		
		Assert.assertEquals(logoutCheck, "Sign out");
		log.info("Assertion Passed Successfully");
		lp.LogoutBtn().click();		
		log.info("Logged Out Successfully");
		log.info("*************Login Test - Passed*****************");
	}
	
}
