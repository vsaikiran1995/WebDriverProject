package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		// launch the browser
		WebDriver driver = new ChromeDriver();
		// Open the website
		driver.get("https://demoqa.com/alerts");
		// Max the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		WebElement btn = driver.findElement(By.cssSelector("button#alertButton"));
		btn.click();
		
		Alert obj = driver.switchTo().alert();
		Thread.sleep(2000);
		obj.accept();
		
		
		WebElement btn1 = driver.findElement(By.cssSelector("button#confirmButton"));
		Thread.sleep(2000);
		btn1.click();
		
		obj = driver.switchTo().alert();
		Thread.sleep(2000);
		obj.dismiss();
		
		
		

	}

}
