package section9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Elements {
	
	public static void main(String[] args) {
		
		//setup driver and open url
				WebDriverManager.chromedriver().setup();
				WebDriver fx = new ChromeDriver();
				fx.get("http://way2automation.com/way2auto_jquery/index.php");
				fx.manage().window().maximize(); //maximize the window
				WebElement we = fx.findElement(By.name("country"));
				Select select = new Select(we);
				//select.selectByVisibleText("Germany");
				select.selectByValue("Germany");
				
				//System.out.println(select.getOptions().size()); same as below code
				//System.out.println(select.getOptions().get(4).getText());
				List<WebElement> values = fx.findElements(By.tagName("option"));
				System.out.println("Count of values: "+values.size());
				
				//printing all values from dropdown
				for(int i =0; i<values.size();i++) {
					System.out.println(values.get(i).getText());
				//	System.out.println(values.get(i).getAttribute("lang"));
				}
	}

}
