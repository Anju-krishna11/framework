package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class tetlogin {
	WebDriver driver;
	@Test(dataProvider="logindata")
	public void test(String user,String pav)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pav);
		driver.findElement(By.id("submit")).click();
	}
	@AfterClass
	public void test2()
	{
		driver.close();
	}
	@DataProvider(name="logindata")
	public Object[][] data(){
		return new Object[][] {
			{"username","password"},
			{" student","Password123"}
		};
		}
	}

