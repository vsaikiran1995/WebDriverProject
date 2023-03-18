package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) throws InterruptedException {
		// ctrl+shift=F to format code
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		// launch the browser
		WebDriver driver = new ChromeDriver();
		// Open the website
		driver.get("https://www.facebook.com/");
		// Max the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		// Send username
		WebElement username = driver.findElement(By.id("email"));
		username.sendKeys("Welcome1234");
		// Send password
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("Test@123");
		// Click login button
		WebElement login = driver.findElement(By.name("login"));
		login.click();

		Thread.sleep(10000);
		driver.close();

	}

}
