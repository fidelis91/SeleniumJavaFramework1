package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_GoogleSearch {
	
	public static void main(String[] args) {
		googleSearch();
		
	}
	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//goto Google.com
		driver.get("https://google.com");
		
		//enter text in search textbox
		driver.findElement(By.name("q")).sendKeys("Automation step by Step");
		
		//click on search button
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//close browser
		driver.close();
		System.out.println("Test Completed Successfully");
		
	}

}
