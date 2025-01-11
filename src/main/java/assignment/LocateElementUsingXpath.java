package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocateElementUsingXpath {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("v.m.patil54@gmai.com");
		Thread.sleep(3000);
		driver.close();
	}

}
