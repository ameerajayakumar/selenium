package section14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionMouseOver {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Navigating to Google.com");
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		System.out.println("Searching for 'way2automation'");
		driver.findElement(By.name("q")).sendKeys("way2automation");
		System.out.println("Clicking on Google Search button");
		
		//elementnottraceable error if not present
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"))).click();
		System.out.println("Clicking on first link on search results");
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/a/h3")).click();
		WebElement menu = driver.findElement(By.xpath("/html/body/div[4]/div/header/div[3]/div/nav/div[2]/ul/li[8]/a"));
		Actions a = new Actions(driver);
		a.moveToElement(menu).perform();
		driver.findElement(By.linkText("Practice site 1")).click();
		
	}

}
