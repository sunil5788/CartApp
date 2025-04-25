package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeScreenPageObjects;
import pageObjects.LoginScrennPageObjects;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class CartLoginClass extends BaseClass {

	@Test(groups = {"Master","Sanity","Regression"})
	public void loginTest()
	{
		try {
			HomeScreenPageObjects home = new HomeScreenPageObjects(driver);
			home.clickMyAccount();
			home.clickLogin();
			
			LoginScrennPageObjects logi = new LoginScrennPageObjects(driver);
			logi.setLoginUserName(pr.getProperty("loginid"));
			logi.setLoginUserPassword(pr.getProperty("password"));
			logi.setLogin();
		
			MyAccountPage acc = new MyAccountPage(driver);
			Boolean message = acc.isMyAccountPageisExits();
			//Assert.assertEquals(message, true,"Login Failed");
			acc.logout();
			Assert.assertTrue(message);
			
		
		}catch (Exception e) {
			Assert.fail();
		}
		
	}
	
	
}
