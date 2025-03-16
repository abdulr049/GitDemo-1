package AscentBusiness.Resilience;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		List<WebElement> tableRows = driver
				.findElements(By.xpath("//div[@class='left-align'] //table[@id='product']/tbody/tr/td[1]"));
		System.out.println(tableRows.size());

		System.out.println(
				driver.findElements(By.xpath("//div[@class='left-align'] //table[@id='product']/tbody/tr/th")).size());

		List<WebElement> secondRowsData = driver
				.findElements(By.xpath("//div[@class='left-align'] //table[@id='product']/tbody/tr[3]/td"));

		for (WebElement secondRowData : secondRowsData) {
			System.out.println(secondRowData.getText());

		}

	}

}
