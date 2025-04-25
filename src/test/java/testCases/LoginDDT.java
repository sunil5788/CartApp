package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeScreenPageObjects;
import pageObjects.LoginScrennPageObjects;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

//This test case is for data driven test [Multiple valued] passed to test cases using Data providers


public class LoginDDT extends BaseClass {

	
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class)
	public void LoginDDTestCase(String email, String pass, String res)
	{
	try {	
		HomeScreenPageObjects home = new HomeScreenPageObjects(driver);
		home.clickMyAccount();
		home.clickLogin();
		
		LoginScrennPageObjects logi = new LoginScrennPageObjects(driver);
		logi.setLoginUserName(email);
		logi.setLoginUserPassword(pass);
		logi.setLogin();
	
		MyAccountPage acc = new MyAccountPage(driver);
		boolean message = acc.isMyAccountPageisExits();
	
		if(res.equalsIgnoreCase("valid"))
		{
			if(message == true)
			{
				acc.logout();
				Assert.assertTrue(true);
			}else {
				Assert.assertTrue(false);
			}
		}
		
		if(res.equalsIgnoreCase("invalid")) {
			if(message == true)
			{
				acc.logout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
		
		
	}catch (Exception e) {
        e.printStackTrace();
		Assert.fail();
	}
	
	}
}
