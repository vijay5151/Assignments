package assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemonstrateRadioButton {

	WebDriver driver;
	@BeforeTest
	void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		Dimension d=new Dimension(300,600);
		driver.manage().window().setSize(d);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
	}
	@Test
	void data() {
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		driver.findElement(By.xpath("//input[@value='2']")).click();
	}
	@AfterTest
	void teardawn() {
		driver.close();
	}
}
