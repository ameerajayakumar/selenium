package section9;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {
	
	public static Logger log = Logger.getLogger((TestBrowsers.class.getName()));

	public static void main(String[] args) {

		//log4j
		Date d = new Date();
		System.setProperty("current.date", d.toString().replace(":","_").replace(" ", "_")); //replacing : and space with _ in date format and setting it as system property
		PropertyConfigurator.configure("/Users/ameeraj/eclipse-workspace/Selenium-Workspace/selenium/src/test/resources/properties/log4j.properties");
		
		
		//setup driver and open url
		WebDriverManager.chromedriver().setup();
		WebDriver fx = new ChromeDriver();
		
		//explicitwait
		//WebDriverWait wait = new WebDriverWait(fx, 10);
		
		//implicitwait
		//fx.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//fluentwait
		Wait<WebDriver> w = new FluentWait<WebDriver>(fx)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(5,TimeUnit.SECONDS)
				.withMessage("Timed out in 10 seconds!!!!-USER DEFINED")
				.ignoring(NoSuchElementException.class);
		
		log.info("Opening URL in firefox browser");
		fx.get("https://accounts.google.com/");
		log.info("Successfully opened URL in browser!!!");
		
		fx.manage().window().maximize(); //maximize the window
		
		String title = fx.getTitle();
		log.info(title); //printing the title
		
		WebElement username = fx.findElement(By.id("identifierId"));
		//cssselector:#identifierId
		username.sendKeys("trainer@way2automation.com");
		log.info("typed in username");
		
		fx.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/span")).click();
		log.info("clicking on next button");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("hellohello");
		
		//fx.findElement(By.name("password")).sendKeys("hellohello");
		fx.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/span")).click();
		System.out.println(w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span"))).getText());
		fx.close();
		
		
	}

}
