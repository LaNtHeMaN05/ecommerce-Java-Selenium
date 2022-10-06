package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span/i[@class='icon-plus']")
	private WebElement addQuantity;
	
	@FindBy(xpath = "//input[@id='quantity_wanted']")
	private WebElement addQuantityTextbox;
	
	@FindBy(xpath="//select[@id='group_1']")
	private WebElement sizeDropDown;
	
	@FindBy(xpath = "//button[@name='Submit']")
	private WebElement cartSubmit;
	
	@FindBy(xpath="//div/span[@title='Continue shopping']")
	private WebElement continueFromProdDetails;
	
	
	
	public ProductDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public WebElement addQuant() {
		return addQuantity;
	}
	
	public WebElement addQuantText() {
		return addQuantityTextbox;
	}
	
	public WebElement dropDownSize() {
		return sizeDropDown;
	}
	
	public WebElement submitProduct() {
		return cartSubmit;
	}
	
	public WebElement contShopping() {
		return continueFromProdDetails;
	}
}
		