package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UseofNavigateButton {

	public static void main(String[] args) throws Exception {
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      
      driver.get("https://www.facebook.com/r.php?entry_point=login");
      driver.manage().window().maximize();
      driver.navigate().forward();
      Thread.sleep(1000);
      driver.navigate().back();
      Thread.sleep(1000);
      driver.navigate().refresh();
      Thread.sleep(2000);
      driver.close();
	}

}
