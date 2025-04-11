package tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ExcelData;

public class LoginTest extends BaseTest {

	@Test(groups = {"Smoke"})
	public void validUserLogin() throws EncryptedDocumentException, IOException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(ExcelData.readExcelData(1, 0));
		loginPage.enterPassword(ExcelData.readExcelData(1, 1));
		loginPage.clickLoginBtn();
		InventoryPage inv = new InventoryPage(driver);
		inv.clickmenubtn();
		inv.clicklogoutbtn();

	}

	@Test
	public void invalidUserLogin() throws EncryptedDocumentException, IOException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(ExcelData.readExcelData(1, 0));
		loginPage.enterPassword(ExcelData.readExcelData(1, 2));
		loginPage.clickLoginBtn();
		loginPage.verifyErrormesg();

	}
}
