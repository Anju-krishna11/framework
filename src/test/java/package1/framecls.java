package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class framecls {
	WebDriver driver;
	@Test(dataProvider="logindata")
	public void frame(String user,String pass)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login-button")).click();
	}
	@AfterClass
	public void frame2()
	{
		driver.close();
	}
	@DataProvider(name="logindata")
	public Object[][] data(){
		return new Object[][] {
			
			{"username","password"},
			{"standard_user","secret_sauce"},
			{"anju12","1234"},
		};
	}
}


