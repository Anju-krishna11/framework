package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class parabank {
	WebDriver driver;
	@Test(dataProvider="logindata")
	public void reg(String Anju,String K,String Bangalore,String Madiwala,String Karnataka,String jjjj,String tet,String abc,String anju,String def,String ghi)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/index.htm;jsessionid=81A6E762AD3EBB496E882D3862A503ED");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();
		driver.findElement(By.id("customer.firstName")).sendKeys(Anju);
		driver.findElement(By.id("customer.lastName")).sendKeys(K);
		driver.findElement(By.id("customer.address.street")).sendKeys(Bangalore);
		driver.findElement(By.id("customer.address.city")).sendKeys(Madiwala);
		driver.findElement(By.id("customer.address.state")).sendKeys(Karnataka);
		driver.findElement(By.id("customer.address.zipCode")).sendKeys(jjjj);
		driver.findElement(By.id("customer.phoneNumber")).sendKeys(tet);
		driver.findElement(By.id("customer.ssn")).sendKeys(abc);
		driver.findElement(By.id("customer.username")).sendKeys(anju);
		driver.findElement(By.id("customer.password")).sendKeys(def);
		driver.findElement(By.id("repeatedPassword")).sendKeys(ghi);
		driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
	}
	@AfterClass
	public void reg1()
	{
		driver.close();
	}
	@DataProvider(name="logindata")
	public Object[][]data(){
		return new Object[][] {
			{"firtname","latname","addre","city","tt","zipcode","phone","no","username","password","repeatedPassword"},
			{"Anju","K","bangalore","madiwala","Kaentaka","56666","9876543210","33","anju","12345","12345"},
		};
		
		
		
	}

}
