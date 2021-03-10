package section14;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Jquerycalender {
	public static WebDriver driver;

	static int targetDate = 0, targetMonth = 0, targetYear = 0, currentDate = 0, currentMonth = 0, currentYear = 0, jumpMonthsBy = 0, jumpYearsBy = 0;
	static boolean incm = true, incy= true;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		String date = "15/01/1992";
		getCurrentDate();
		getTargetDate(date);
		calculateMonthYear();
		System.out.println(jumpMonthsBy + "  " + jumpYearsBy);

		driver = new FirefoxDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		driver.findElement(By.id("datepicker")).click();

		for (int i = 0; i < jumpYearsBy*12; i++) {
			if (incy) {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			} else {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}
		}
		for (int i = 0; i < jumpMonthsBy; i++) {
			if (incm) {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
			} else {
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			}
			Thread.sleep(1000);
		}
		driver.findElement(By.linkText(Integer.toString(targetDate))).click();

	}

	public static void getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		currentDate = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH) + 1;
		currentYear = cal.get(Calendar.YEAR);
		System.out.println(currentDate + "  " + currentMonth + "  " + currentYear);
	}

	public static void getTargetDate(String date) {

		int firstIndex = date.indexOf("/");
		int lastIndex = date.lastIndexOf("/");
		String day = date.substring(0, firstIndex);
		targetDate = Integer.parseInt(day);
		String month = date.substring(firstIndex + 1, lastIndex);
		targetMonth = Integer.parseInt(month);
		String year = date.substring(lastIndex + 1, date.length());
		targetYear = Integer.parseInt(year);
		System.out.println(targetDate + "  " + targetMonth + "  " + targetYear);
	}

	public static void calculateMonthYear() {
		if (targetMonth - currentMonth > 0) {
			jumpMonthsBy = (targetMonth - currentMonth);
		} else {
			jumpMonthsBy = (currentMonth - targetMonth);
			incm = false;
		}
		if (targetYear - currentYear > 0) {
			jumpYearsBy = (targetYear - currentYear);
		} else {
			jumpYearsBy = (currentYear - targetYear);
			incy = false;
		}
	}

}
