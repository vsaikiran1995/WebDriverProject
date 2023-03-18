package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {
		
		//Step=1 launch chrome browser and open simplilearn website
		//Step=2 Maximize the browser
		//Step=3 Click on the login link on top right corner
		//Step=4 Enter the username
		//Step=5 Enter the password
		//Step=6 Click on the Submit button
		//Step=7 Validate the login is successfull
		
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.simplilearn.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		//WebElement loginlink = driver.findElement(By.linkText("Log in"));
		//loginlink.click();
		
		driver.findElement(By.linkText("Log in")).click();
		
		System.out.println(driver.getTitle());
		
		WebElement username = driver.findElement(By.name("user_login"));
		username.sendKeys("vsaikiran1995@gmail.com");
		//driver.findElement(By.name("user_login")).sendKeys("vsaikiran1995@gmail.com");
		driver.findElement(By.name("user_pwd")).sendKeys("Test@123");
		//Click on remember me check box
		driver.findElement(By.className("rememberMe")).click();
		//Click on submit button
		driver.findElement(By.name("btn_login")).click();
		
		WebElement error = driver.findElement(By.className("error_msg"));
		String errorMsg = error.getText();
		System.out.println(errorMsg);
		String expErrorMsg = "The email or password you have entered is invalid.";
		if(error.isDisplayed() && errorMsg.equals(expErrorMsg)) {
			System.out.println("TC Passed");
		}
		else
			System.out.println("TC Failed");
		
		// find the all links in the browser
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		for(WebElement link:allLinks){
			System.out.println(link.getAttribute("href"));
		}
		
		//Close the browser
		driver.close();


	}

}
