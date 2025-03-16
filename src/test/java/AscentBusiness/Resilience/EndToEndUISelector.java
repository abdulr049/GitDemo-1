package AscentBusiness.Resilience;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EndToEndUISelector {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.manage().window().maximize();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		List<WebElement> DepartureCities = driver.findElements(By.xpath("//div[@class='dropdownDiv']/ul/li"));

		for (WebElement DepartureCity : DepartureCities) {
			if (DepartureCity.getText().equalsIgnoreCase("Bengaluru (BLR)")) {
				DepartureCity.click();
			}
		}

		List<WebElement> ArrivalCities = driver.findElements(By.xpath("//div[@class='dropdownDiv']/ul/li"));

		for (WebElement ArrivalCity : ArrivalCities) {
			if (ArrivalCity.getText().equalsIgnoreCase("Bagdogra (IXB)")) {
				ArrivalCity.click();
			}
		}

		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();

		driver.findElement(By.id("Div1"));

		if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains(".5")) {
			System.out.println("It is not enabled :");
		}

		else {
			System.out.println("It is enabled :");
		}

		driver.findElement(By.id("divpaxinfo")).click();

		for (int i = 0; i <= 3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click();

		WebElement ListCurrency = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select DropDownListCurrency = new Select(ListCurrency);
		DropDownListCurrency.selectByIndex(1);

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

	}

}
