package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemoWithTestNG {

	ExtentSparkReporter spark;
	ExtentReports extent;
	
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		spark = new ExtentSparkReporter("Spark1.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
	}

	@Test
	public void test1() {
		
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		driver.get("https://google.com");
		test.pass("Navigated to google.com");
		
		test.log(Status.INFO, "This step shows usage of log(status, ");
		test.info("This step shows usage of info(details)");
		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");

	}
	
	@Test
	public void test2() {
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		test.log(Status.INFO, "This step shows usage of log(status, ");
		test.info("This step shows usage of info(details)");
		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test.addScreenCaptureFromPath("screenshot.png");

	}
	@AfterTest
	public void tearDownTest() {
		//close browser
				driver.close();
				driver.quit();
				System.out.println("Test Completed Successfully");
		
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();

	}
}
