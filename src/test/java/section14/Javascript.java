package section14;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript {
	public static WebDriver driver;

	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot//" + filename));
	}

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.switchTo().frame("iframeResult");
		// driver.findElement(By.xpath("/html/body/button")).click();
		// ((JavascriptExecutor)driver).executeScript("myFunction()");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("myFunction()");
		js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));
		captureScreenshot();
		driver.switchTo().defaultContent();
	}

}
