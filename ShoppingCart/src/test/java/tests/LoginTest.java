package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utils.RetryAnalyser;

public class LoginTest extends BaseTest {

	@Test
	public void validUserLogin() {

		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginBtn();
		InventoryPage inv=new InventoryPage(driver);
		inv.clickmenubtn();
		inv.clicklogoutbtn();
		
			
	}
	@Test
	public void invalidUserLogin() {

		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauc");
		loginPage.clickLoginBtn();
		loginPage.verifyErrormesg();
		
			
	}
}
