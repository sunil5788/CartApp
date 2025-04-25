package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeScreenPageObjects;
import pageObjects.RegistrationPageObjects;
import testBase.BaseClass;

public class CartRegisterClass extends BaseClass {

	@Test (groups ={"Master","Regression"})
	public void registerTest() {
		
		try {
			HomeScreenPageObjects homescreen = new HomeScreenPageObjects(driver);
			homescreen.clickMyAccount();
			homescreen.clickRegister();

			RegistrationPageObjects regista = new RegistrationPageObjects(driver);

			regista.setUserName(randomString().toLowerCase());
			regista.setLastName(randomString().toLowerCase());
			regista.setEmailName(randomString() + "@gmail.com");
			regista.setTelephoneNumber(randomNumber());
			String password = randomPassword();
			regista.setPassword(password);
			regista.setConfirmPassword(password);
			regista.setTick();
			regista.onClickSubmit();
			String mess = regista.setConfirmationMessage();
			Assert.assertEquals(mess, "Your Account Has Been Created!");
		}catch (Exception e) {
			Assert.fail();
		}
		
	}

}
