package section9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PresenceElement {
	public static WebDriver fx;
	
	public static boolean isElementPresent(By by) {
		try {
			fx.findElement(by);
			return true;
		}catch(Throwable t) {
			return false;
		}
	}
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		fx = new ChromeDriver();
		fx.get("https://www.wikipedia.org/");
		fx.manage().window().maximize(); // maximize the window

		WebElement we = fx.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/strong"));
		System.out.println(we.isDisplayed());
		System.out.println(isElementPresent(By.xpath("//*[@id=\"js-link-box-en\"]/strong")));
		fx.close();
	}

}
