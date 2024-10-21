package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObject {
	
	WebDriver driver = null;
	
	By texbox_search = By.id("APjFqb");
	By button_search = By.name("btnK");
	
	public GoogleSearchPageObject(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void setTextInSearchBox(String text){
		driver.findElement(texbox_search).sendKeys(text);
		
	}
	
	public void clickSearchButton() {
		driver.findElement(button_search).sendKeys(Keys.RETURN);
	}

}
