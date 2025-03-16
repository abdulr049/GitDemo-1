package AscentBusiness.Resilience;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tr/th[1]")).click();

		List<WebElement> VeggieList = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalVeggieList = VeggieList.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedVeggieList = originalVeggieList.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(originalVeggieList.equals(sortedVeggieList));
		
		

	}

}
