package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemonstrateContainsMethod {
    public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[contains(@id,'u_0_8_ ')]")).sendKeys("Simon");
		Thread.sleep(2000);
		driver.close();
	}
}
