package AscentBusiness.Resilience;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AlertHandling {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.manage().window().maximize();

		driver.findElement(By.id("name")).sendKeys("Abdul Rahaman");

		driver.findElement(By.id("alertbtn")).click();

		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);

		Assert.assertEquals("Hello Abdul Rahaman, share this practice page and share your knowledge", alertText);

		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();

		String confirmText = driver.switchTo().alert().getText();
		System.out.println(confirmText);

		driver.switchTo().alert().dismiss();

	}

}
