package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

	public WebDriver driver;

	@Parameters({ "browser" })
	@BeforeMethod
	public void beforeTest(String browser) {

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			break;

		default:
			break;
		}

	}

	@AfterMethod
	public void afterTest() {

		if (driver != null) {
			driver.quit();

		}

	}
}
