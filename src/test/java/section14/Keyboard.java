package section14;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyboard {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://gmail.com");
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("helloo");
	    WebElement w =	driver.findElement(By.xpath("//*[@id='headingSubtext']/span"));
	    w.click();
		//username.sendKeys(Keys.ENTER);
		Actions a = new Actions(driver);
		//a.sendKeys(Keys.ENTER).perform();
		a.keyDown(Keys.COMMAND).sendKeys(Keys.chord("a")).keyUp(Keys.COMMAND).keyDown(Keys.COMMAND).sendKeys(Keys.chord("c")).keyUp(Keys.COMMAND).perform();
		driver.findElement(By.id("identifierId")).click();
		a.keyDown(Keys.COMMAND).sendKeys(Keys.chord("v")).keyUp(Keys.COMMAND).perform();
		}
}
  