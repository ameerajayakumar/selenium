package assignments;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Three {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		int num1, num2, result = 0;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("Navigating to timesofindia url");
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		String[] captcha = driver.findElement(By.id("mathq2")).getText().split(" ");
		char operator = captcha[1].charAt(0);
		num1 = Integer.parseInt(captcha[0]);
		num2 = Integer.parseInt(captcha[2]);

		switch (operator) {
		case '+':
			System.out.println("Adding the numbers");
			result = num1 + num2;
			break;
		case '-':
			System.out.println("Subtracting the numbers");
			result = num1 - num2;
			break;
		case '*':
			System.out.println("Multiplying the numbers");
			result = num1 * num2;
			break;
		case '÷':
			System.out.println("Dividing the numbers");
			result = num1 / num2;
			break;

		default:
			break;
		}
		driver.findElement(By.id("mathuserans2")).sendKeys(Integer.toString(result));
		System.out.println("Entered captcha!");
	}
}
