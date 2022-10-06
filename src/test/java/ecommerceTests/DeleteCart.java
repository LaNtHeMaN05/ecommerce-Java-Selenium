package ecommerceTests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.BaseClass;

public class DeleteCart extends BaseClass {
	
	WebDriver driver;
	Logger log=LogManager.getLogger(DeleteCart.class.getName());
	
	@BeforeTest
	public void initDriver() throws IOException {
		driver=webDriverStart();
	}
	
	@Test
	public void DeleteCartItems() {
		
		driver.get(testURL);
		log.info("Test URL Loaded Successfully");
		HomePage hp=new HomePage(driver);
		hp.clickLogin().click();
		
		LoginPage lp=new LoginPage(driver);
		lp.emailEnter().sendKeys(correct_id);
		lp.passwordEnter().sendKeys(pswd);
		lp.signClick().click();
		lp.homebtn().click();
		log.info("Login Successful");
		
		
	}

}
