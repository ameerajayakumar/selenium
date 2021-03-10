package section14;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabsPopups {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.quackit.com/html/codes/html_popup_window_code.cfm");
		driver.switchTo().frame("result1");
		
		Set <String> ids = driver.getWindowHandles();
		Iterator <String> i = ids.iterator();
		String first = i.next();
		driver.findElement(By.xpath("/html/body/p/a")).click();
		ids = driver.getWindowHandles();
		i = ids.iterator();
		System.out.println(i.next());
		String seco = i.next();
		driver.switchTo().window(seco);
		System.out.println(driver.findElement(By.xpath("/html/body/div[1]/article/p[1]")).getText());
	}

}
