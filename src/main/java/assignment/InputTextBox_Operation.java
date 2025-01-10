package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InputTextBox_Operation {

	public static void main(String[] args) throws Exception {
     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
     
     driver.get("https://www.facebook.com/r.php?entry_point=login");
     driver.manage().window().maximize();
     driver.findElement(By.name("firstname")).sendKeys("Vijay");
     Thread.sleep(2000);
     driver.close();
	}
}
