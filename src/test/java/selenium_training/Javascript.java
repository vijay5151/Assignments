package selenium_training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript {

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
	void data() throws Exception {
		
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,-2000)");
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		//jse.executeScript("document.getElementByid(inputValEnter).value='mobile'");
		WebElement searchbox=driver.findElement(By.id("inputValEnter"));
		jse.executeScript("arguments[0].setAttribute('value','mobile')",searchbox);
		Thread.sleep(2000);
		WebElement button=driver.findElement(By.className("searchTextSpan"));
		jse.executeScript("arguments[0].click()",button);
		Thread.sleep(4000);
	}
	@AfterTest
	void teardawn() {
		driver.close();
	}
}
