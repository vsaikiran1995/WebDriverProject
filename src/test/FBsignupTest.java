package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBsignupTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		// launch the browser
		WebDriver driver = new ChromeDriver();
		// Open the website
		driver.get("https://www.facebook.com/");
		// Max the window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// Click on create new account
		WebElement signup = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signup.click();
		Thread.sleep(3000);
		
		WebElement fname=driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lname=driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement no=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement pass= driver.findElement(By.xpath("//*[@id='password_step_input']"));
		
		fname.sendKeys("test");
		lname.sendKeys("account");
		no.sendKeys("1234567890");
		pass.sendKeys("Test@123");
		
		WebElement selectedDay = driver.findElement(By.xpath("//select[@title='Day']/option[@selected='1']"));
		System.out.println("The default day is "+selectedDay.getText());
		
		WebElement selectedMonth = driver.findElement(By.xpath("//select[@title='Month']/option[@selected='1']"));
		System.out.println("The default day is "+selectedMonth.getText());
		
		WebElement selectedYear = driver.findElement(By.xpath("//select[@title='Year']/option[@selected='1']"));
		System.out.println("The default day is "+selectedYear.getText());
		
		//printing list of WebElements text for months DropDown
		List<WebElement> list=driver.findElements(By.xpath("//select[@title='Month']/option"));
		for(WebElement x:list) {
			System.out.println(x.getText());
		}
		
		
		WebElement day=driver.findElement(By.xpath("//select[@title='Day']"));
		Select ddDay= new Select(day);
		ddDay.selectByVisibleText("19");
		
		
		WebElement month =driver.findElement(By.xpath("//select[@title='Month']"));
		Select ddmonth= new Select(month);
		ddmonth.selectByVisibleText("Apr");
		
		WebElement year =driver.findElement(By.xpath("//select[@title='Year']"));
		Select ddyear= new Select(year);
		ddyear.selectByVisibleText("2023");
		
		WebElement female=driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		female.click();
		
		//Important concept*** Gender selection Dynamic code
		//**************************************************
		String gender = "Male";
		String dummyXpath="//label[text()='tobechanged']";
		String newXpath=dummyXpath.replace("tobechanged", gender);
		System.out.println("New xpath is "+ newXpath);
		
		WebElement genderEle=driver.findElement(By.xpath(newXpath));
		genderEle.click();		
		
		Thread.sleep(3000);
		driver.close();
	}

}
