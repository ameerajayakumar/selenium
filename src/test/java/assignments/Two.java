package assignments;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Two {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Navigating to qa.way2automation url");
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		System.out.println("Typing in name for registration");
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Ameera");
		driver.findElements(By.cssSelector("input[value='Submit']")).get(1).click();
		System.out.println("Clicked on Submit button");

	}

}
