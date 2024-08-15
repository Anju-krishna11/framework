package package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class petstore {
	public class datadrivenexcel {
		 WebDriver driver;
		    String excelFilePath = "E:\\Testing\\petstore.xlsx";
		    Workbook workbook;
		    Sheet sheet;
		    
		    @BeforeClass
		    public void setup() throws IOException {
		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
		        driver = new ChromeDriver();
		        
		        try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath))) {
		            workbook = new XSSFWorkbook(inputStream);
		            sheet = workbook.getSheetAt(0);
		        }
		    }
		    
		    @Test
		    public void datadriven() throws InterruptedException, IOException {
		        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		            Row row = sheet.getRow(i);
		            String akn = row.getCell(0).getStringCellValue();
		            String abc = row.getCell(1).getStringCellValue();

		            driver.get("https://petstore.octoperf.com/actions/Account.action;jsessionid=0CCFF012A42F401E81D18CFCFD88FE49?signonForm=");
		            driver.manage().window().maximize();
		            driver.findElement(By.name("username")).sendKeys(akn);
		            driver.findElement(By.name("password")).sendKeys(abc);
		            driver.findElement(By.name("signon")).click();
		            Thread.sleep(3000);

		            Cell resultCell = row.createCell(2);
		            if (isLoginSuccessful()) {
		                resultCell.setCellValue("Pass");
		            } else {
		                resultCell.setCellValue("Fail");
		            }
		        }
		    }

		    private boolean isLoginSuccessful() {
		        // Implement logic to verify if login is successful
		        try {
		            driver.findElement(By.xpath("//*[@id=\"WelcomeContent\"]")); // Change to the actual confirmation element's id
		            return true;
		        } catch (Exception e) {
		            return false;
		        }
		    }

		    @AfterClass
		    public void teardown() throws IOException {
		        try (FileOutputStream outputStream = new FileOutputStream(new File(excelFilePath))) {
		            workbook.write(outputStream);
		        }
		        workbook.close();
		        driver.quit();
		    }
		}



	}


