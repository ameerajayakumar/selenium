package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Five {
	public static WebDriver driver;

	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Throwable t) {
			return false;
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
		for (WebElement f : frame) {
			driver.switchTo().frame(f);
			if (isElementPresent(By.xpath("/html/body/button"))) {
				driver.findElement(By.xpath("/html/body/button")).click();
				System.out.println(driver.findElement(By.xpath("//*[@id=\"demo\"]")).getText());
				driver.switchTo().defaultContent();
				break;
			}
		}
		System.out.println("Done!");
	}
}
