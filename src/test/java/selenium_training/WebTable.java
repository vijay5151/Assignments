package selenium_training;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	WebDriver driver;
	@BeforeTest
	void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Dimension d=new Dimension(600,500);
		driver.manage().window().setSize(d);
		Thread.sleep(2000);
		driver.manage().window().maximize();
	}
	@Test
	void data() {
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement ref=driver.findElement(By.xpath("//table[@id='main_table_countries_today']//tbody/tr[8]/td[5]"));
		System.out.println(ref.getText());
		System.out.println();
		int row=driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr")).size();
		System.out.println("Number of rows ="+row);
		int col=driver.findElements(By.xpath("//table[@id='main_table_countries_today']/thead/tr/th")).size();
		System.out.println("Number of columns ="+col);
		System.out.println();
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=col; j++) {
				WebElement ref2=driver.findElement(By.xpath("//table[@id='main_table_countries_today']//tbody/tr["+i+"]/td["+j+"]"));
				System.out.print(ref2.getText()+" ");
		}
		}
	}
	@AfterTest
	void teardawn() {
		driver.close();
	}
}
