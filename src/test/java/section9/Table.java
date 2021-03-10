package section9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver fx = new ChromeDriver();
		fx.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		fx.manage().window().maximize(); // maximize the window
		List<WebElement> row = fx.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr"));
		List<WebElement> col = fx.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td"));
		
		System.out.println("Total number of rows and columns: "+ row.size() + " & "+ col.size());
		for(int r=1;r<=row.size();r++) {
			for(int c=1;c<=col.size();c++) {
				System.out.print(fx.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr["+r+"]/td["+c+"]")).getText()+"               ");
			}
			System.out.println();
		}


	}

}
