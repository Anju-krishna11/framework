package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class parabankexcel {
	WebDriver driver;
	@Test
	public void datadriven() throws InterruptedException
	{
		String excelFilePath = "C:\\Users\\HP\\Documents\\parabank.xlsx";
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		try {
            FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                
                // Get data from the current row
                String Anju = row.getCell(0).getStringCellValue();
                String K = row.getCell(1).getStringCellValue();
                String Bangalore = row.getCell(2).getStringCellValue();
                String Madiwala = row.getCell(3).getStringCellValue();
                String Karnataka= row.getCell(4).getStringCellValue();
                String jjjj = row.getCell(5).getStringCellValue();
                String tet = row.getCell(6).getStringCellValue();
                String abc = row.getCell(7).getStringCellValue();
                String anju = row.getCell(8).getStringCellValue();
                String def = row.getCell(9).getStringCellValue();
                String ghi = row.getCell(10).getStringCellValue();
                
		driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=6CC80B96EB2C70EB99BC94B490A83441");
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
		 Thread.sleep(3000); 
            }
            
            workbook.close();
            inputStream.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Close the browser
        driver.quit();
	}
	
		
	}




