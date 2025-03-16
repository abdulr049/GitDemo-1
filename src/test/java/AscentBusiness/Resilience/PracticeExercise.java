package AscentBusiness.Resilience;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeExercise {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(By.xpath("//label[2]//span[2]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));

		driver.findElement(By.id("okayBtn")).click();
		WebElement occupationList = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select selectOccupation = new Select(occupationList);
		selectOccupation.selectByIndex(1);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));
		List<WebElement> cardLists = driver.findElements(By.xpath("//button[@class='btn btn-info']"));

		for (WebElement cardList : cardLists) {
			System.out.println(cardList.getText());
			cardList.click();
		}
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

		List<WebElement> checkOutBoxLists=driver.findElements(By.xpath("/html/body/app-root/app-shop/div/div/div/table/tbody/tr/td/div/div/h4/a"));
		for(WebElement checkOutBoxList:checkOutBoxLists)
		{
			System.out.println(checkOutBoxList.getText());
		}
	}

}
