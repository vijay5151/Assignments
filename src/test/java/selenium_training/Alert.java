package selenium_training;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	WebDriver driver;
	@BeforeTest
	void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Dimension d=new Dimension(400,600);
		driver.manage().window().setSize(d);
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
	}
	@Test
	void data() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		Thread.sleep(2000);
		
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
	}
	@AfterMethod
	void teardawn() {
		driver.close();
	}
}
