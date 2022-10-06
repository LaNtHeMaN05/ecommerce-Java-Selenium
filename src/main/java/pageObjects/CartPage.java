package pageObjects;

import java.security.PublicKey;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;

	@FindBys(@FindBy(xpath = "//td/p"))
	private List<WebElement> totalItems;
	
	@FindBy(xpath="//span[@id='summary_products_quantity']")
	private WebElement summaryProds;

	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public List<WebElement> totalItemsList() {
	return totalItems;
	}
	
	public WebElement summaryList() {
		return summaryProds;
	}

}
