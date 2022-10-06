package ecommerceTests;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductDetailsPage;
import resources.BaseClass;

public class ProductDetailsTest extends BaseClass {
	
	public WebDriver driver;

	Logger log = LogManager.getLogger(ProductDetailsTest.class.getName());

	@BeforeTest
	public void initializeWebDriver() throws IOException {
		log.info("**************Product Details Test - Started****************");
		driver = webDriverStart();
		log.info("Driver Initialized Successfully");

	}

	@Test
	public void product_more_details_addCart_Test() throws InterruptedException {

		driver.get(testURL);
		log.info("Test URL Loaded Successfully");
		HomePage hp = new HomePage(driver);
		hp.clickLogin().click();

		LoginPage lp = new LoginPage(driver);
		lp.emailEnter().sendKeys(correct_id);
		lp.passwordEnter().sendKeys(pswd);
		lp.signClick().click();
		lp.homebtn().click();
		log.info("Login Successful");

		List<WebElement> dressList = hp.printedDressesSelect();
		ProductDetailsPage pdp = new ProductDetailsPage(driver);

		log.info("Loop Starting for each product to be added");

		

		for (int i = 0; i < dressList.size(); i++) {
			log.info("Clicking the Product to view more Details");
			hp.printedDressesSelect().get(i).click();
			for (int j = 0; j < 3; j++) {
				pdp.addQuant().click();
			}
			log.info("Quantity Added for this product");
			Select s = new Select(pdp.dropDownSize());
			s.selectByVisibleText("L");
			pdp.submitProduct().click();
			log.info("Product Submitted to cart");
			pdp.contShopping().click();
			lp.homebtn().click();
			log.info("Redirecting to Home-page");
			log.info("Loop Completed for this product");

		}
		
		log.info("*************************Product Details Test - Completed****************************");
	}

}
