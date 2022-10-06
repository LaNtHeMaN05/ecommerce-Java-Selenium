package ecommerceTests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchResultsPage;
import resources.BaseClass;

public class Seach_and_AddCart_Test extends BaseClass {
	
	public WebDriver driver;
	
	Logger log=LogManager.getLogger(Seach_and_AddCart_Test.class.getName());
	
	
	@BeforeTest
	public void initializeWebDriver() throws IOException {
		log.info("**************Search and AddCart Test - Started****************");
		driver=webDriverStart();
		log.info("Driver Initialized Successfully");
		
	}
	
	@Test
	public void search_addCar_Test() throws InterruptedException {
		
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
		hp.search().sendKeys("Dress");
		hp.searchSubmit().click();
		log.info("Search was completed Successfully");
		SearchResultsPage srp=new SearchResultsPage(driver);
		List<WebElement> items = srp.individualItems();
		int itemsSize=items.size();
		System.out.println(items.size());
		Actions a=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(1));
		log.info("Explicit Wait initialized for adding to cart");
		WebElement proceed=driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
		for(int i=0;i<itemsSize;i++) {
			a.moveToElement(srp.individualItems().get(i)).build().perform();
			a.moveToElement(srp.addCartBtn().get(i)).click().build().perform();
			wait.until(ExpectedConditions.invisibilityOf(proceed));
			srp.continueShopBtn().click();
			log.info("Adding Element to CART");
			
		}
		srp.cart().click();
		log.info("Navigating to CART");
		CartPage cp=new CartPage(driver);
		
		String[] summaryofProducts=cp.summaryList().getText().split(" ");
		log.info("Summary Items was concatenated with product list");
		System.out.println(summaryofProducts[0]);
		Assert.assertEquals(Integer.toString(itemsSize),summaryofProducts[0]);
		log.info("Assertion Successful with added products to CART");

		
	}

}
