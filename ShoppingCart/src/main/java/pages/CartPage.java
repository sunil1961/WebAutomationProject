package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	By productAdded = By.cssSelector(".inventory_item_name");
    By checkotBtn=By.id("checkout");
	public CartPage(WebDriver driver) {
		this.driver = driver;

	}

	public void verifyProductName(String prodName) {
		String actProdname = driver.findElement(productAdded).getText();
		assertEquals(actProdname, prodName);
	}

	
	public void clickCheckoutBtn() {
		driver.findElement(checkotBtn).click();
	}
}
