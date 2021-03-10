package assignments;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Four {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resources/demos/resizable/default.html");
		int w = 50, h = 50;
		for(int i =0;i<=700;i+=20) {
			Dimension d = new Dimension(w+i, h+i);
			driver.manage().window().setSize(d);
		}
	}

}
