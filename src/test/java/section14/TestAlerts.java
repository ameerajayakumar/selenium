package section14;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAlerts {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.cssSelector("input[value='Sign in']")).click();
		//driver.switchTo().alert().accept();
		Alert a = driver.switchTo().alert();
		System.out.println(a.getText());
		a.accept();
		
		//WebDriverWait w = new WebDriverWait(driver, 10);
		//w.until(ExpectedConditions.alertIsPresent());
		//a.accept();
	}

}
