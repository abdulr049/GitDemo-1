package AscentBusiness.Resilience;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinksDemo {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		List<WebElement> links=driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		
		SoftAssert softAssert=new SoftAssert();
		
		for(WebElement link:links)
		{
			String url=link.getAttribute("href");
			
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode=conn.getResponseCode();
			//System.out.println(resCode);
			softAssert.assertTrue(resCode<400, "Broken Link: "+link.getText());
		}
		
		softAssert.assertAll();
	}

}
