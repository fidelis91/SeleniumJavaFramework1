package demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITDemo {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Testing\\JavaProject\\SeleniumJavaFramework\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://practice.expandtesting.com/upload");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("file")).click();
		
		Runtime.getRuntime().exec("C:\\Users\\User\\Desktop\\Testing\\FileUploadScript.exe");
		
		Thread.sleep(3000);
		driver.close();
	}

}
