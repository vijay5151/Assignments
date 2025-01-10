 package selenium_training;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

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
	@Test
	void data() throws InterruptedException {
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.findElement(By.xpath("//button[@id='newTabBtn']")).click();
		String w1=driver.getWindowHandle();
		System.out.println(w1);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='newTabsBtn']")).click();
		Set<String> xyz=driver.getWindowHandles();
		System.out.println(xyz.size());
		Iterator<String> opq=xyz.iterator();
		String window1=opq.next();
		String window2=opq.next();
		String window3=opq.next();
		String window4=opq.next();
		driver.switchTo().window(window1);
		System.out.println(driver.getTitle());
		driver.switchTo().window(window2);
		System.out.println(driver.getTitle());
		driver.switchTo().window(window3);
		System.out.println(driver.getTitle());
		driver.switchTo().window(window4);
		System.out.println(driver.getTitle());
	}
	@AfterTest
	void teardawn(){
		driver.quit();
	}
}
