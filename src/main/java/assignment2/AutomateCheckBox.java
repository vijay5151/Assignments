package assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateCheckBox {

	WebDriver driver;
	@BeforeTest
	void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		Dimension d=new Dimension(300,400);
		driver.manage().window().setSize(d);
		Thread.sleep(1000);
		driver.manage().window().maximize();
	}
	@Test
	void data() throws InterruptedException {
	driver.get("https://artoftesting.com/samplesiteforselenium");
	driver.findElement(By.className("Automation")).click();
	Thread.sleep(2000);
	}
	@AfterTest
	void teardawn() {
		driver.close();
	}
}
