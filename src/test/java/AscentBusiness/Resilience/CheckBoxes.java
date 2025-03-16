package AscentBusiness.Resilience;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxes {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		System.out.println(checkBoxes.size());

		boolean se = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected();

		// assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		Assert.assertFalse(se, "Checkbox is selected");

		driver.findElement(By.xpath("//label[@for='ctl00_mainContent_chk_friendsandfamily']")).click();

		// Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected(),
		// "Checkbox is selected");

		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected(), "Checkbox is not selected");

		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
		driver.close();

	}

}
