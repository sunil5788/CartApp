package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BasePage;


public class HomeScreenPageObjects  extends BasePage {
	
	
	public HomeScreenPageObjects(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement btn_click_my_register;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement btn_register;
	
	
	
   @FindBy(xpath = "//a[normalize-space()='Login']")
   WebElement btn_login;
	
	public void clickMyAccount()
	{
		btn_click_my_register.click();
	}

	public void clickRegister()
	{
		btn_register.click();
	}
	
	public void clickLogin()
	{
		btn_login.click();
	}
	
}
