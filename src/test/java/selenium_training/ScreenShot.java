package selenium_training;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	WebDriver driver;
	@BeforeTest
	void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Dimension d=new Dimension(400,500);
		driver.manage().window().setSize(d);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
	}
	@Test
	void data() throws Exception {
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		TakesScreenshot sc=(TakesScreenshot)driver;
		File load=sc.getScreenshotAs(OutputType.FILE);
		File source=new File("C:\\Users\\VIJAY\\Desktop\\Excel Data\\viju.jpg");
		FileUtils.copyFile(load, source);
		
		
	}
	@Test
	void deta() throws Exception {
		driver.get("https://www.facebook.com/");
		WebElement fb=driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
		File load=fb.getScreenshotAs(OutputType.FILE);
		File source=new File("C:\\Users\\VIJAY\\Desktop\\Excel Data\\fb.jpg");
		FileUtils.copyFile(load, source);
		
	}
	@AfterTest
	void teardawn() {
		driver.close();
	}
}
