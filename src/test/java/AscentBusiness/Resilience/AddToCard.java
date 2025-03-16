package AscentBusiness.Resilience;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCard {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		String[] veggies = { "Brocolli", "Apple", "Tomato" };
		List<String> veggiesList = Arrays.asList(veggies);

		List<WebElement> productsList = driver.findElements(By.xpath("//h4[@class='product-name']"));

		int productCount = productsList.size();

		for (int i = 0; i < productCount; i++) {
			// System.out.println(productsList.get(i).getText());

			String productName = productsList.get(i).getText();
			String productName1[] = productName.split("-");
			String nameWithSpace = productName1[0];
			String actualProductName = nameWithSpace.trim();

			if (veggiesList.contains(actualProductName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			}
		}

		driver.findElement(By.xpath("//div[@class='cart'] //a[@class='cart-icon']")).click();

		List<WebElement> cardItems = driver
				.findElements(By.xpath("//div[@class='product-info'] //p[@class='product-name']"));

		int cardCount = cardItems.size();

		for (int i = 0; i < cardCount; i++) {
			String cardProductName = cardItems.get(i).getText();
			String[] CardSplitName = cardProductName.split("-");
			String cardProductNameWithSpace = CardSplitName[0];
			String actualCardProductName = cardProductNameWithSpace.trim();
			System.out.println(actualCardProductName);

			if (veggiesList.contains(actualCardProductName)) {
				System.out.println("List is Matching");
			}
		}

	}

}
