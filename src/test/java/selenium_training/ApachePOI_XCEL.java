package selenium_training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ApachePOI_XCEL {

	WebDriver driver;
	@BeforeTest
	void setup() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	void data() throws Exception {
		FileInputStream load=new FileInputStream("C:\\Users\\VIJAY\\Desktop\\Excel Data\\vijay.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(load);
		XSSFSheet sh=wb.getSheet("sheet1");
		System.out.println(sh.getSheetName());
		driver.get("https://www.snapdeal.com/");
		WebElement ref=driver.findElement(By.xpath("//input[@id='inputValEnter']"));
		ref.sendKeys(sh.getRow(5).getCell(1).getStringCellValue());
		Thread.sleep(1000);
		ref.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
	}
	@AfterTest
	void teardawn() {
		driver.close();
	}
}
