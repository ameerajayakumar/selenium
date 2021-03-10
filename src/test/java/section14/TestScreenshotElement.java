package section14;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenshotElement {

	public static WebDriver driver;

	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1, new File(".//screenshot//" + filename));
	}
	public static void captureElementScreenshot(WebElement ele) throws IOException {
		Date d = new Date();
		String filename = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File screenshot1 = ((TakesScreenshot) ele).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot1, new File(".//screenshot//" + filename));
	}

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		//not working below
		WebElement e = driver.findElement(By.xpath("//img[@id='hplogo']"));
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage img = ImageIO.read(screenshot);
		Point loc = e.getLocation();
		int h = e.getSize().height;
		int w = e.getSize().width;
		BufferedImage elesc = img.getSubimage(loc.x, loc.y, w, h);
		ImageIO.write(elesc, "jpg", screenshot);
		File screenshotloc = new File(".//screenshot//googlelogo.jpg");
		FileUtils.copyFile(screenshot, screenshotloc);
		
		//below code works fine
		captureElementScreenshot(e);
	}
}
