package AscentBusiness.Resilience;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProcessList {

	public static void main(String[] args) throws InterruptedException {

		// https://alrajhi-sit.ascentbusiness.com/main/risk-assessment/ra-process/40

		WebDriver driver = new ChromeDriver();

		driver.get("https://alrajhi-sit.ascentbusiness.com/main/risk-assessment/ra-process/40");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.findElement(By.id("password")).sendKeys("admin");
		
		driver.findElement(By.id("kc-login")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.manage().window().maximize();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Thread.sleep(30000);
		
		
		driver.findElement(
				By.xpath("//span[text()='Select Process']"))
				.click();
		List<WebElement> processLists=driver.findElements(By.xpath("//span[@class='ng-star-inserted']"));
		
		System.out.println(processLists.size());
		
		for(WebElement processList:processLists)
		{
			System.out.println(processList.getText());
		}
		
	}
		

	}


