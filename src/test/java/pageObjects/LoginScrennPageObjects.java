package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class LoginScrennPageObjects extends BasePage{

	public LoginScrennPageObjects(WebDriver driver) {
		super(driver);
	}
	


	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_login_userName;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_login_password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_login;
	
	
	
	
	public void setLoginUserName(String loginName)
	{
		txt_login_userName.sendKeys(loginName);
	}
	 
	public void setLoginUserPassword(String loginPass)
	{
		txt_login_password.sendKeys(loginPass);
	}
	
	public void setLogin()
	{
		btn_login.click();
	}
}
