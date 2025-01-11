package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetrivetextFromWebElement {

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		driver.manage().window().maximize();
		String name=driver.findElement(By.xpath("//div[@class='mbs _52lq _9bp_ fsl fwb fcb']")).getText();
		Thread.sleep(2000);
		System.out.println(name);
		driver.close();
	}

}
