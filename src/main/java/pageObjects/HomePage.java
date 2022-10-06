package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	@FindBy(xpath="//a[@class='login']")
	private WebElement loginBtn;
	
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@name='submit_search']")
	private WebElement searchIcon;
	
	@FindBys(@FindBy(xpath="//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li//div//h5/a[@title='Printed Dress']"))
	private List<WebElement> printedDresses;
	
	@FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li//div//div[@class='button-container']/a[@title='View']")
	private WebElement moreDetailsBtn;
	
	@FindBy(xpath="//div/a/span[@class='ajax_cart_quantity']")
	private WebElement cartCount;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public WebElement clickLogin() {
		return loginBtn;
	}
	
	public WebElement search() {
		return searchBox;
	}
	
	public WebElement searchSubmit() {
		return searchIcon;
	}
	
	public List<WebElement> printedDressesSelect() {
		return printedDresses;
	}
	
	public WebElement moreDetails() {
		return moreDetailsBtn;
	}
	
	public WebElement getCartCount() {
		return cartCount;
	}
}
