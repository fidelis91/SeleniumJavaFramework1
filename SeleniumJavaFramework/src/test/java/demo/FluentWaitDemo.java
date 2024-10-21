package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {
	
	public static void main(String[] args) throws Exception {
		test();
	}
	
	public static void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\Testing\\JavaProject\\SeleniumJavaFramework\\drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("ABCD");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//driver.findElement(By.linkText("The ABCD study: understanding the development of risk for ...")).click();
		
		
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(30L))
		       .pollingEvery(Duration.ofSeconds(2L))
		       .ignoring(NoSuchElementException.class);

		   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       WebElement linkElement = driver.findElement(By.linkText("ABCD Definition & Meaning"));
		       
		       if(linkElement.isEnabled()) {
		    	   System.out.println("Element Found");
		    	   
		       }
		       return linkElement;
		     }
		   });
		   
		   
		  element.click();

		
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
	}

}
