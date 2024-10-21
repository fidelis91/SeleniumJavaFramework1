import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://google.com/");
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("abcd");
		
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		
		int count = listOfInputElements.size();
		
		System.out.println("Count of Input Elements : "+count);
		
		//WebElement textBox = driver.findElement(By.id("APjFqb")); 
		
		//textBox.sendKeys("Automation step by step");
		
		Thread.sleep(3000);
		driver.close();
		//driver.quit();
	}

}
 