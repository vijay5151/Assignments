package selenium_training;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseAction {

	WebDriver driver;
	@BeforeTest
	void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Dimension d=new Dimension(400,600);
		driver.manage().window().setSize(d);
		Thread.sleep(1000);
		driver.manage().window().maximize();

	}
	@Test
	void data() throws InterruptedException {
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement cart=driver.findElement(By.xpath("//span[text()='Cart']"));
		Actions ref=new Actions(driver);
		ref.moveToElement(cart).build().perform();
		Thread.sleep(1000);
		ref.contextClick(cart).build().perform();
		Thread.sleep(1000);
		ref.release(cart).build().perform();
		Thread.sleep(1000);
		WebElement cat=driver.findElement(By.xpath("//li[@navindex='4']"));
		ref.click(cat).build().perform();
		Thread.sleep(2000);
	}
	@AfterTest
	void teardawn() {
		driver.quit();
	}
}
