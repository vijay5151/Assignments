package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demonstrate_IDNameLinkText {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("email")).sendKeys("mobile");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Forgotten account?")).click();
		Thread.sleep(2000);
		//driver.navigate().back();
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.partialLinkText("Your BIS"));
		Thread.sleep(5000);
		System.out.println("Testcase passed");
		driver.quit();
		
	}

}
