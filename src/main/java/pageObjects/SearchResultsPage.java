package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	
	WebDriver driver;
	
	@FindBys(@FindBy(xpath="//div/div[@class='product-image-container']"))
	private List<WebElement> individualShopItem;
	
	@FindBys(@FindBy(xpath="//span[contains(text(),'Add to cart')]"))
	private List<WebElement> addtoCart;

	@FindBy(xpath="//span/i[@class='icon-chevron-left left']")
	private WebElement continueShopping;
	
	@FindBys(@FindBy(xpath="//div/div/span[@itemprop='price']"))
	private List<WebElement> price;
	
	@FindBy(xpath="//div/span[@class='ajax_block_cart_total']")
	private WebElement totalPriceAjax;
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	private WebElement cartView;
	
	@FindBys(@FindBy(xpath="//span/a[@title='remove this product from my cart']"))
	private List<WebElement> cartItems;
	
	
	public SearchResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public List<WebElement> addCartBtn() {
		return addtoCart;
	}
	
	public WebElement continueShopBtn() {
		return continueShopping;
	}
	
	public List<WebElement> individualItems(){
		return individualShopItem;
	}
	
	public List<WebElement> getPrice(){
		return individualShopItem;
	}
	
	public WebElement priceinAjax() {
		return totalPriceAjax;
	}
	
	public WebElement cart() {
		return cartView;
	}
	
	public List<WebElement> itemsOfCart() {
		return cartItems;
	}
}
