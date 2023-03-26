package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandlingExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		// launch the browser
		WebDriver driver = new ChromeDriver();
		// Open the website
		driver.get("https://demoqa.com/browser-windows");
		// Max the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement newTab = driver.findElement(By.id("tabButton"));
		String parentWin = driver.getWindowHandle();
		System.out.println("Parent window id "+ parentWin);
		newTab.click();
		
		Set<String> allWin = driver.getWindowHandles();
		String childWin="";
		for(String win:allWin) {
			System.out.println(win);
			if(!win.equals(parentWin)) {
				childWin=win;
			}
		}
		driver.switchTo().window(childWin);
		WebElement prt = driver.findElement(By.cssSelector("h1#sampleHeading"));
		System.out.println(prt.getText());
		driver.close();
		
		driver.switchTo().window(parentWin);
		WebElement newWindow=driver.findElement(By.id("windowButton"));
		newWindow.click();
		
		allWin = driver.getWindowHandles();
		
		for(String win:allWin) {
			System.out.println(win);
			if(!win.equals(parentWin)) {
				childWin=win;
			}
		}
		driver.switchTo().window(childWin);
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		driver.close();
		
		
	}

}
