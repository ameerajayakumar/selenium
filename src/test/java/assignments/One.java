package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class One {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Navigating to Google.com");
		driver.get("https://www.google.com/");
		System.out.println("Searching for 'way2automation'");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("way2automation");
		System.out.println("Clicking on Google Search button");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]")).click();
		System.out.println("Clicking on first link on search results");
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).click();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Count of all links on page: "+links.size());
		System.out.println("Printing all link information:");
		for(WebElement we:links) {
			System.out.println("Link Text: "+we.getText()+" Link URL: "+we.getAttribute("href"));
		}
	}

}
