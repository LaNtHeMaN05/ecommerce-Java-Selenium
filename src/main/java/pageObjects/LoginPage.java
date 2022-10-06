package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailId;
	
	@FindBy(xpath="//input[@name='passwd']")
	private WebElement pswd;
	
	@FindBy(xpath = "//button[@name='SubmitLogin']")
	private WebElement logibBtn;
	
	@FindBy(xpath="//ol/li")
	private WebElement AuthMessage;
	
	@FindBy(xpath="//div/a[@class='logout']")
	private WebElement logOut;
	
	@FindBy(xpath="//img[@alt='My Store']")
	private WebElement homeBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}


	public WebElement emailEnter() {
		return emailId;
	}
	
	public WebElement passwordEnter() {
		return pswd;
	}
	
	public WebElement signClick() {
		return logibBtn;
	}
	
	public WebElement AuthMsg() {
		return AuthMessage;
	}
	
	public WebElement LogoutBtn() {
		return logOut;
	}
	
	public WebElement homebtn() {
		return homeBtn;
	}
}
