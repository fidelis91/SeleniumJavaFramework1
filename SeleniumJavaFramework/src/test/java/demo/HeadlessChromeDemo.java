package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {
	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Testing\\JavaProject\\SeleniumJavaFramework\\drivers\\chromedriver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		//options.addArguments("window-size=1920,1080");
		
		WebDriver driver = new ChromeDriver(options);
		
		
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		driver.close();
		driver.quit();
		
		System.out.println("Completed");
		
	}

}
