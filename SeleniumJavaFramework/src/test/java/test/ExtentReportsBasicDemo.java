package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver = null;

	public static void main(String[] args) {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		
		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		
		// creates a toggle for the given test, add all log events under it
		ExtentTest test1 = extent.createTest("Google Search Test One", "this is a test to validate google search functionality");
		
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://google.com");
		test1.pass("Navigated to google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		test1.pass("Entered text in Searchbox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Pressed Keyboard enter key");
		
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		
		test1.info("Test Completed");
		
		// calling flush writes everything to the log files
		extent.flush();
	}

}
