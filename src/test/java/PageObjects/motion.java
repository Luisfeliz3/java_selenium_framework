package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Tests.BaseTest;
 
import Tests.convertYaml;

 

public class motion extends BaseTest {
	WebDriver driver;
 
	convertYaml selects = new convertYaml();
	public motion(WebDriver driver) {
			this.driver = driver;
 			 
	}
	
	
	public void click(WebDriver driver,String locatorName) {
		WebElement element = selects.locator(driver, locatorName );
		 element.click();
		 return;
	}

	
	
	public void sendKeys(WebDriver driver,String locatorName, String string) {
		WebElement element = selects.locator(driver, locatorName );
		 element.sendKeys(string);
		 return;
	}
	

	
	public void isDiplayed(WebDriver driver,String locatorName) {
	     WebElement element = selects.locator(driver, locatorName );
	     element.isDisplayed();
	}
	
	public void isEnanble(WebDriver driver,String locatorName) {
		  WebElement element = selects.locator(driver, locatorName );
		 element.isEnabled();
		 return;
	}
 
	public void isSelected(WebDriver driver,String locatorName) {
		 WebElement element = selects.locator(driver, locatorName );
		 element.isSelected();
		 return;
	}

	
	
	
	public String getText(WebDriver driver,String locatorName) {
		WebElement element = selects.locator(driver, locatorName );
		String text  = element.getText();
		System.out.println(text= "RETURNING TEXT TO GET TEXT !!");
		return text;
	}

}
