package section14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rightclick {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		WebElement img = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/div[2]/table[1]/tbody/tr/td[3]/p[2]/img"));
		Actions a = new Actions(driver);
		a.contextClick(img).perform();
		WebElement e1 = driver.findElement(By.id("dm2m1i1tdT"));
		a.moveToElement(e1).perform();
		WebElement e2 = driver.findElement(By.id("dm2m2i1tdT"));
		a.moveToElement(e2).perform();
		WebElement e3 = driver.findElement(By.id("dm2m3i1tdT"));
		a.moveToElement(e3).click().perform();
		
	}

}
