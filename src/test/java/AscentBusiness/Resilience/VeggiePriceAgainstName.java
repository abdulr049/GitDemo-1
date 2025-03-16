package AscentBusiness.Resilience;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VeggiePriceAgainstName {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

		String veggieName = "Cheese";
		boolean veggieFound = false;

		while (true) {
			List<WebElement> vaggiesList = driver.findElements(By.xpath("//tr/td[1]"));

			for (WebElement vaggie : vaggiesList) {
				if (vaggie.getText().equalsIgnoreCase(veggieName)) {
					String price = driver.findElement(By.xpath("//td[text()='"+veggieName+"']/following-sibling::td[1]")).getText();
					System.out.println("Price of '" + veggieName + "': " + price);
					veggieFound = true;
					break;
				}
			}

			if (veggieFound==true) {
				break;
			}

			// Check if the next page button is enabled and click
			WebElement nextButton = driver.findElement(By.cssSelector("a[aria-label='Next']"));
			if (nextButton.isEnabled()) {
				nextButton.click();
			} else {
				break; // Exit loop if no more pages
			}
		}

	}

}
