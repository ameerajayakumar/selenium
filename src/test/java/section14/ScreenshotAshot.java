package section14;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenshotAshot {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://way2automation.com/");
		WebElement e = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header"));
		// Screenshot s = new
		// AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		Screenshot s = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver, e);
		ImageIO.write(s.getImage(), "jpg", new File(".//screenshot//ashot.jpg"));

	}

}
