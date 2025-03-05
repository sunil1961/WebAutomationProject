package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	
	WebDriver driver;
    protected By userNameField=By.id("user-name");
	protected By passWordField=By.id("password");
	protected By loginBtn=By.id("login-button");
	protected By errormesg=By.xpath("//h3[@data-test='error']");
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	public void enterUserName(String userName) {
		driver.findElement(userNameField).sendKeys(userName);
			
	}
	public void enterPassword(String password) {
		driver.findElement(passWordField).sendKeys(password);
		
	}
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	public void verifyErrormesg() {
		String ermesg=driver.findElement(errormesg).getText();
		Assert.assertEquals(ermesg,"Epic sadface: Username and password do not match any user in this service");
	}

}
