package assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementNotfountException {
public static void main(String[] args) throws Exception {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://demoqa.com/text-box");
	driver.findElement(By.id("userName")).sendKeys("selenium");
	driver.findElement(By.id("email")).sendKeys("sdkjdk");
	Thread.sleep(1000);
	driver.close();
}
}