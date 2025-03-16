package AscentBusiness.Resilience;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestedHandlingDropdown {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.linkText("English")).click();
		
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Indi");
		
		List<WebElement> searchList=driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
		
		for(WebElement searchItem:searchList)
		{
			if(searchItem.getText().equalsIgnoreCase("india vs australia"))
			{
				searchItem.click();
			}
			
			System.out.println(searchItem.getText());
		}
		
	}

}
