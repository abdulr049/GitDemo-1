package AscentBusiness.Resilience;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.findElement(By.id("divpaxinfo")).click();

		driver.findElement(By.id("hrefIncAdt")).click();

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.findElement(By.id("btnclosepaxoption")).click();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		List<WebElement> dropdownList = driver.findElements(By.xpath("//div[@class='dropdownDiv']/ul/li"));

		Thread.sleep(2000);
		for (WebElement x : dropdownList) {
			if (x.getText().equalsIgnoreCase("Patna (PAT)")) {
				x.click();
			}

		}

		List<WebElement> DropDownCity = driver.findElements(By.xpath("//div[@class='dropdownDiv']/ul/li"));
		Thread.sleep(2000);

		for (WebElement city : DropDownCity) {
			if (city.getText().equalsIgnoreCase("Mumbai (BOM)")) {
				city.click();
			}
		}

		// driver.close();

	}

}
