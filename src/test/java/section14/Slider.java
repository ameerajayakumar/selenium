package section14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();
		WebElement sliwe = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
		WebElement slider = driver.findElement(By.id("slider"));
		int length = (slider.getSize().width)/2;
		new Actions(driver).dragAndDropBy(sliwe, length, 0).perform();
	}

}
