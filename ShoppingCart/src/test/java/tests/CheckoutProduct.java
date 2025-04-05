package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutInfoPage;
import pages.CheckoutSuccessPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ExcelData;

public class CheckoutProduct extends BaseTest {
//String ProdName="Sauce Labs Bolt T-Shirt";

	@Test
	public void checkoutItem() throws EncryptedDocumentException, IOException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(ExcelData.readExcelData(1, 0));
		loginPage.enterPassword(ExcelData.readExcelData(1, 1));
		loginPage.clickLoginBtn();
		InventoryPage invn = new InventoryPage(driver);
		invn.addProductTocart(ExcelData.readExcelData(1, 6));
		invn.clickCartIcon();
		CartPage cpage = new CartPage(driver);
		cpage.verifyProductName(ExcelData.readExcelData(1, 6));
		cpage.clickCheckoutBtn();
		CheckoutInfoPage cInfopage = new CheckoutInfoPage(driver);
		cInfopage.enterUserDetails(ExcelData.readExcelData(1, 3), ExcelData.readExcelData(1, 4),
				ExcelData.readExcelData(1, 5));
		cInfopage.clickContinueBtn();
		cInfopage.verifycheckoutOverView();
		cInfopage.clickFinishBtn();
		CheckoutSuccessPage succpage = new CheckoutSuccessPage(driver);
		succpage.verifycheckoutSuccess();
		succpage.navigateToProdPage();
		invn.clickmenubtn();
		invn.clicklogoutbtn();

	}
}
