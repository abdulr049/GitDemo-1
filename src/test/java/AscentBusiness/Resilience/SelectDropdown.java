package AscentBusiness.Resilience;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class SelectDropdown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		String indexText = "INR";
		boolean match = false;

		WebElement selectList = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select selectOption = new Select(selectList);
		selectOption.selectByIndex(1);
		System.out.println(selectOption.getFirstSelectedOption().getText());

		Object indexOption = selectOption.getFirstSelectedOption().getText();

		if (indexText.equals(indexOption)) {
			match = true;
		}
		if (match == true) {
			System.out.println("Matching index value");
		} else {
			System.out.println("Not Matching index value");
		}
		
		selectOption.selectByVisibleText("AED");
		System.out.println(selectOption.getFirstSelectedOption().getText());

		selectOption.selectByValue("USD");
		System.out.println(selectOption.getFirstSelectedOption().getText());


	}

}
