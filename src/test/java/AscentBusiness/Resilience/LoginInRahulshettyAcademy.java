package AscentBusiness.Resilience;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginInRahulshettyAcademy {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		//driver.findElement(By.id("inputUsername")).sendKeys("rahul");

		String password2 = getPassword(driver);
		
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");

		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password2);

		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {

		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();

		String passwordMessage = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
		//System.out.println(passwordMessage);

		driver.findElement(By.xpath("//button[@class='go-to-login-btn']")).click();

		String[] pass = passwordMessage.split("'");
		String password = pass[1];

		String[] password1 = password.split("'");
		String passowrdOriginal = password1[0];

		return passowrdOriginal;

	}

}
