package AscentBusiness.Resilience;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='Nested Frames']")).click();
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		driver.switchTo().frame(0);
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
		
		driver.switchTo().defaultContent();

	}

}
