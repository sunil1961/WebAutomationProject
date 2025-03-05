package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutSuccessPage {
	
	WebDriver driver;
	By chekoutCompleteLbl=By.className("title");
	By SuccessmesgLbl=By.className("complete-header");
	By backBtn=By.id("back-to-products");
	
	
	public CheckoutSuccessPage(WebDriver driver) {
		this.driver=driver;
	}
	public void verifycheckoutSuccess() {
		String actText=	driver.findElement(chekoutCompleteLbl).getText();
		String succmesg=driver.findElement(SuccessmesgLbl).getText();
		assertEquals(actText, "Checkout: Complete!");
		assertEquals(succmesg, "Thank you for your order!");
		
		}
	public void navigateToProdPage() {
		driver.findElement(backBtn).click();
	}
	


}
