package assignment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Click Me'][@onclick='myMessage()']")).click();
		Wait<WebDriver> w=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(6))
				.pollingEvery(Duration.ofMillis(200));
		w.until(ExpectedConditions.alertIsPresent());

		driver.switchTo().alert().accept();
		driver.close();
		System.out.println("Fluent wait successfully passed");


	}
}
