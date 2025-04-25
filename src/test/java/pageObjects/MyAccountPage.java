package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;
	
	
	
	@FindBy(xpath = "//div[@class= 'list-group']//a[text()='Logout']")
	WebElement btn_logout;
	
	public Boolean isMyAccountPageisExits()
	{
		try {
			
			return (msgHeading.isDisplayed());
		}catch (Exception e) {
			return false;
		} 
		
		
	}
	
	public void logout()
	{
		btn_logout.click();
	}
}
