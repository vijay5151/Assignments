package assignment2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemonstrateDropdawnWithSelectclass {

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
	driver.get("https://www.facebook.com/r.php?entry_point=login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement ref=driver.findElement(By.id("month"));
	Select as=new Select(ref);
	as.selectByVisibleText("Feb");
	Thread.sleep(2000);
	}
	@AfterTest
	void tardawn() {
		driver.close();
	}
}
