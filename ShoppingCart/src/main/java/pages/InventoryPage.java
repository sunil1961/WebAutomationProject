package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

	 WebDriver driver;
		By ItemDesc= By.cssSelector(".inventory_item_description");
		By cartLink=By.cssSelector(".shopping_cart_link");
		By menubtn=By.xpath("//button[text()='Open Menu']");
		By logoutbtn=By.xpath("//a[text()='Logout']");
		
	    	
		public InventoryPage(WebDriver driver) {
			this.driver=driver;
		}
		
		public void addProductTocart(String prodName) {
		List<WebElement> element=driver.findElements(ItemDesc);
		for (WebElement webElement : element) {
			if (webElement.findElement(By.cssSelector(".inventory_item_name")).getText().contains(prodName)) {
				webElement.findElement(By.cssSelector(".btn_inventory")).click();
				break;
			}
			
		}}
		public void clickCartIcon() {
			driver.findElement(cartLink).click();
		}
		
		public void clickmenubtn() {
			driver.findElement(menubtn).click();
		}
		public void clicklogoutbtn() {
			driver.findElement(logoutbtn).click();
		}
		
		
		
		


}
