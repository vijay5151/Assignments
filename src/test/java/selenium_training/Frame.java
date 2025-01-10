package selenium_training;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {

	WebDriver driver;
	@BeforeTest
	void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Dimension d=new Dimension(600,400);
		driver.manage().window().setSize(d);
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}
	@Test
	void data() throws Exception {
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.switchTo().frame("frm1");
		WebElement ref=driver.findElement(By.id("selectnav1"));
		Select asd=new Select(ref);
		asd.selectByVisibleText("Tutorials");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.switchTo().frame("frm2");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("fName")).sendKeys("Vijay");
		Thread.sleep(1000);
		driver.findElement(By.id("lastName")).sendKeys("Patil");
		Thread.sleep(1000);

	}
	@AfterMethod
	void teardawn() {
		//driver.close();
		driver.quit();
	}
}
