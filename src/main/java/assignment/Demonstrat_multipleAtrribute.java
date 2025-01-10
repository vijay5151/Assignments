package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demonstrat_multipleAtrribute {

	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		driver.findElement(By.xpath("//input[@data-type='text'][@aria-label='First name']")).sendKeys("Vijay");
		Thread.sleep(2000);
		driver.close();
		
	}
}
