package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;
import testBase.BasePage;

public class RegistrationPageObjects extends BasePage {

	public RegistrationPageObjects(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_userName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lastName;
	
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_telephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_confirm_password;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement txt_tick;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmarion;
	

	public void setUserName(String username)
	{
		txt_userName.sendKeys(username);
	}
	
	public void setLastName(String lastName)
	{
		txt_lastName.sendKeys(lastName);
	}
	
	public void setEmailName(String email)
	{
		txt_email.sendKeys(email);
	}
	
	public void setTelephoneNumber(String telephone)
	{
		txt_telephone.sendKeys(telephone);
	}
	
	
	public void setPassword(String password)
	{
		txt_password.sendKeys(password);
	}
	
	
	public void setConfirmPassword(String cpassword)
	{
		txt_confirm_password.sendKeys(cpassword);
	}
	
	
	
	public void setTick()
	{
		txt_tick.click();
	}
	
	
	public void onClickSubmit()
	{
		btn_continue.click();
	}
	
	public String setConfirmationMessage()
	{try {
		return msgConfirmarion.getText();
	}catch (Exception e) {
		return e.getMessage();
	}
	
	   
	}
	

}
