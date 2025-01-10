package selenium_training;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ALL_SSMF {

	WebDriver driver;
	@BeforeTest
	void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		Dimension d=new Dimension(400,600);
		driver.manage().window().setSize(d);
		Thread.sleep(1000);
		driver.manage().window().maximize();
	}
	@Test(priority=6)
	void pfile() throws Exception {
		Properties pro=new Properties();
		FileInputStream ref=new FileInputStream("C:\\Users\\VIJAY\\eclipse-workspace\\Selenium_Trainining_2024\\src\\main\\data.properties");
	     pro.load(ref);
	     pro.getProperty("username");
	     driver.get("https://www.facebook.com/");
	     driver.findElement(By.name("email")).sendKeys(pro.getProperty("username"));
	     Thread.sleep(1000);
	     driver.findElement(By.name("pass")).sendKeys(pro.getProperty("password"));
	     Thread.sleep(2000);
	}
	@Test(priority=5)
	void data() {
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//number of rows
		int row=driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr")).size();
		System.out.println("Number of rows in table ="+row);
		//number of columns in table
		int col=driver.findElements(By.xpath("//table[@id='main_table_countries_today']/thead/tr/th")).size();
		System.out.println("number of column in table ="+col);
		//particular data in table
		WebElement d=driver.findElement(By.xpath("//table[@id='main_table_countries_today']/tbody/tr[7]/td[4]"));
	System.out.println("Data ="+d.getText());
	// get data upta line 10
	for(int i=1; i<=10; i++) {
		for(int j=1; j<=col; j++) {
			WebElement d1=driver.findElement(By.xpath("//table[@id='main_table_countries_today']/tbody/tr["+i+"]/td["+j+"]"));
			System.out.println(d1.getText());
		}
	}
	}
	@Test(priority=3)
	void scroll() throws Exception {
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-1500)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		WebElement search=driver.findElement(By.name("q"));
		jse.executeScript("arguments[0].getAttribute('value','mobile')",search);
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	@Test(priority=4)
	void mouse() throws InterruptedException {
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement cart=driver.findElement(By.xpath("//span[text()='Cart']"));
		Actions ref=new Actions(driver);
		ref.moveToElement(cart).build().perform();
		ref.contextClick(cart).build().perform();
		Thread.sleep(1000);
		ref.release(cart).build().perform();
		Thread.sleep(1000);
		WebElement blog=driver.findElement(By.xpath("//a[text()='Our Blog ']"));
		ref.click(blog).build().perform();
		Thread.sleep(3000);
	}
	@Test(priority=2)
	void screen() throws Exception {
		driver.get("https://www.britannica.com/technology/compressor");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		TakesScreenshot ref=(TakesScreenshot)driver;
		File load=ref.getScreenshotAs(OutputType.FILE);
		File source=new File("C:\\Users\\VIJAY\\Desktop\\Excel Data\\viju.jpg");
		FileUtils.copyFile(load, source);
		
	}
	@Test(priority=1)
	void file() throws Exception {
		File fs=new File("C:\\Users\\VIJAY\\Desktop\\Excel Data\\vijay.xlsx");
		FileInputStream ref=new FileInputStream(fs);
		XSSFWorkbook wb=new XSSFWorkbook(ref);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getSheetName());
		driver.get("https://www.flipkart.com/");
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys(sh.getRow(5).getCell(1).getStringCellValue());
		Thread.sleep(2000);
	}
	@AfterTest
	void teardawn() {
		driver.quit();
	}
} 
