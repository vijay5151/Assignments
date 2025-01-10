package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LounchFirefox_chrome_edgebrowser {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver2=new FirefoxDriver();
		driver2.get("https://www.facebook.com/");
		Thread.sleep(4000);
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver3=new EdgeDriver();
		driver3.get("https://www.facebook.com/");
		Thread.sleep(4000);
		driver.close();
		driver2.close();
		driver3.close();
	}

}
