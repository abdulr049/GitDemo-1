package AscentBusiness.Resilience;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(@href, '/windows')]")).click();
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
//		String childId = it.next();	
		
		String targetedWindow = "New Window";

		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().equalsIgnoreCase(targetedWindow)) 
			{
				System.out.println(driver.findElement(By.xpath("//h3[normalize-space()='New Window']")).getText());
				break;
			}
		}

		driver.switchTo().window(parentId);

		System.out.println(driver.findElement(By.xpath("//h3[normalize-space()='Opening a new window']")).getText());

	}

}
