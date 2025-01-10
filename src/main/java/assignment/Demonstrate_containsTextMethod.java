package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demonstrate_containsTextMethod {

	public static void main(String[] args) throws Exception {

	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.snapdeal.com/");
	driver.findElement(By.xpath("//span[contains(text(),'Cart')]")).click();
	Thread.sleep(2000);
	driver.close();
	}

}
