package section14;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testiframes {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		// driver.switchTo().frame("iframeResult");
		// driver.findElement(By.xpath("/html/body/button")).click();

		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
		System.out.println(frame.size());
		for (WebElement f : frame) {
			driver.switchTo().frame(f);
			List<WebElement> frames = driver.findElements(By.tagName("iframe"));
			System.out.println(frames.size());
			// System.out.println(f.getAttribute("id"));
			driver.switchTo().defaultContent();
		}
	}

}
