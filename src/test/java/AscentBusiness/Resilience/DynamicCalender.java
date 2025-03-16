package AscentBusiness.Resilience;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicCalender {

	public static void main(String[] args) {
		
		
		//a[@class='ui-state-default']
		
		//table[@class='ui-datepicker-calendar']
		
		WebDriver driver = new ChromeDriver();

		

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		List<WebElement> dates=driver.findElements(By.xpath("//a[@class='ui-state-default']"));
		
		List<WebElement> months=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']"));
		
		for(WebElement date:dates)
		{
			System.out.println(date.getText());
		}
		
		for(WebElement month:months)
		{
			System.out.println(month.getText());
		}
		
		
	}

}
