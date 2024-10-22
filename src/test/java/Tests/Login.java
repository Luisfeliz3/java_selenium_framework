package Tests;

 

 
import java.time.Duration;

 
 
import org.testng.annotations.Test;

import PageObjects.motion;

 
public class Login extends BaseTest {
//	LocatorUtil element = new LocatorUtil();
	convertYaml element = new convertYaml();
	motion ele = new motion(driver);
	
		@Test
		public void LandingPage() {
       System.out.println("WE ARE HERE (*&*&*&*&*&");
       
			
			ele.click( driver, "navLoginButton");
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
//			ele.click( driver, "signButton");
		     try {
		            // Pause execution for 5 seconds (5000 milliseconds)
		            Thread.sleep(5000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		     ele.click(driver, "dashboard");
		     try {
		            // Pause execution for 5 seconds (5000 milliseconds)
		            Thread.sleep(2000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }		
		     
		      ele.getText(driver, "statement_balance");
       
		}
 
}
