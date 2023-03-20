package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SLabsLoginTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//Scenario : Happy path login test
		WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
		WebElement pwd=driver.findElement(By.xpath("//input[@id='password']"));
		WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
		
		userName.sendKeys("standard_user");
		pwd.sendKeys("secret_sauce");
		login.click();
		
		WebElement hButton=driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
		WebElement logout=driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
		
		hButton.click();
		
		Thread.sleep(2000);
		
		
		//Scenario : Negative login test
		
		WebDriver driver1 = new ChromeDriver();
		driver1.get("https://www.saucedemo.com/");
		driver1.manage().window().maximize();
		driver1.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement userName1=driver1.findElement(By.xpath("//input[@id='user-name']"));
		WebElement pwd1=driver1.findElement(By.xpath("//input[@id='password']"));
		WebElement login1=driver1.findElement(By.xpath("//input[@id='login-button']"));
		
		
		
		userName1.sendKeys("locked_out_user");
		pwd1.sendKeys("secret_sauce");
		login1.click();
		
		String actual ="Epic sadface: Sorry, this user has been locked out.";
		WebElement error=driver1.findElement(By.xpath("//*[text()='Epic sadface: Sorry, this user has been locked out.']"));
		String expected=error.getText();
		if(actual.contains(expected)) {
			System.out.println("login fail test passed");
		}
		
		driver.close();
		

	}

}
