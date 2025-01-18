package assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demonstrate_ThreadSleep {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		driver.findElement(By.name("firstname")).sendKeys("ajay");
		
		Thread.sleep(2000);
		driver.close();
	}
}
