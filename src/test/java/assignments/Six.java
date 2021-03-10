package assignments;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Six {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> i = ids.iterator();
		while (i.hasNext()) {
			String f = i.next();
			driver.switchTo().window(f);
			System.out.println(driver.getTitle());
		}
	}

}
