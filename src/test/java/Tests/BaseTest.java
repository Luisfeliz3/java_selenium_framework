package Tests;

import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


	 convertYaml elx = new convertYaml();
	static WebDriver driver = new ChromeDriver();
 	Properties prop = new Properties();
 

	@BeforeMethod       
		public void setUp() {		
			try {
				File propFile = new File(System.getProperty("user.dir") + "/src/test/java/utils/data.properties");
				FileReader fr = new FileReader(propFile);
				prop.load(fr);
			
			} catch (Exception e) {
				e.printStackTrace();
			}
								
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
	
 
	
	
	
	@AfterClass
	  public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
	
	
