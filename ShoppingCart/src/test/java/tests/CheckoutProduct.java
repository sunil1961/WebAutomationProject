package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutInfoPage;
import pages.CheckoutSuccessPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutProduct extends BaseTest {
String ProdName="Sauce Labs Bolt T-Shirt";
	
	@Test
	public void checkoutItem() {

		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickLoginBtn();
		InventoryPage invn=new InventoryPage(driver);
		invn.addProductTocart(ProdName);
		invn.clickCartIcon();
		CartPage cpage=new CartPage(driver);
		cpage.verifyProductName(ProdName);
		cpage.clickCheckoutBtn();
		CheckoutInfoPage cInfopage=new CheckoutInfoPage(driver);
		cInfopage.enterUserDetails("reon", "loy", "3211");
		cInfopage.clickContinueBtn();
		cInfopage.verifycheckoutOverView();
		cInfopage.clickFinishBtn();
		CheckoutSuccessPage succpage=new CheckoutSuccessPage(driver);
		succpage.verifycheckoutSuccess();
		succpage.navigateToProdPage();
		invn.clickmenubtn();
		invn.clicklogoutbtn();
		
			
	}
}
