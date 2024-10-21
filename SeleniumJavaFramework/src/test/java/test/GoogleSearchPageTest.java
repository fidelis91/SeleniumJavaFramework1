package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPageObject;

public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		googleSearchTest();
	}
	
	public static void googleSearchTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		GoogleSearchPageObject searchPageObj = new GoogleSearchPageObject(driver);
		
		driver.get("https://google.com");
		
		searchPageObj.setTextInSearchBox("A B C D");
		
		searchPageObj.clickSearchButton();
		
		driver.close();
		
	}

}
