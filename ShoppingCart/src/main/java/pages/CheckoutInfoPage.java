package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage {
WebDriver driver;
	
	By fNameField=By.id("first-name");
	By lNameField=By.id("last-name");
	By postalcdField=By.id("postal-code");
	By continueBtn=By.id("continue");
	By chekoutoverviewLbl=By.className("title");
	By finishBtn=By.id("finish");
	
	
	public CheckoutInfoPage(WebDriver driver) {
		this.driver=driver;
		
	}
	public void enterUserDetails(String fname,String lname,String pcode) {
		driver.findElement(fNameField).sendKeys(fname);
		driver.findElement(lNameField).sendKeys(lname);
		driver.findElement(postalcdField).sendKeys(pcode);
	}
	public void clickContinueBtn() {
		driver.findElement(continueBtn).click();
	}
	public void verifycheckoutOverView() {
	String actText=	driver.findElement(chekoutoverviewLbl).getText();
	assertEquals(actText, "Checkout: Overview");
	}
	public void clickFinishBtn() {
		driver.findElement(finishBtn).click();
		
		
	}
}
