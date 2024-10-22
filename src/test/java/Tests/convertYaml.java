package Tests;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.Yaml;

 

public class convertYaml {
 
 
        private static  String retrieveLocatorValues(String locatorName) {
    		// TODO Auto-generated method stub	
    	
     
        // Load the YAML file
        Yaml yaml = new Yaml();
        
        // Use InputStream to load the file (config.yml)
        InputStream inputStream = Yaml.class.getClassLoader().getResourceAsStream("config.yml");
        
  
        Map<String, String> yamlData = yaml.load(inputStream);
		        
        
        String keyToFind = locatorName;
        System.out.println(keyToFind + "THIS IS THE KEYTO FIND!!%^&*!(&^!%&*");
        for (Map.Entry<String, String> entry : yamlData.entrySet()) {
            String key = entry.getKey();
            String value = entry.toString().replace(locatorName + "=", "");
            
            if (key.equals(keyToFind)) {
                System.out.println("Key: " + key + " exists with value: " + value);
                return value;
               
            } else {
                System.out.println("Key: " + key + " does not match the search key.");
            }
            
            
        }

        // You can also use containsKey() to directly check if the key exists
        if (yamlData.containsKey(keyToFind)) {
            System.out.println("The key '" + keyToFind + "' exists with value: " + yamlData.get(keyToFind));
        } else {
            System.out.println("The key '" + keyToFind + "' does not exist in the YAML data.");
        }
		return keyToFind;
	 
       
     
      
    }
        
        private static WebElement getElement(WebDriver driver, String locator, String selector) {
        	
            switch (selector) {
                case "id":
                    return driver.findElement(By.id(locator));
                   
                case "css":
                    return driver.findElement(By.cssSelector(locator));
                case "xpath":
                    return driver.findElement(By.xpath(locator));
                case "linkText":
                    return driver.findElement(By.linkText(locator));
                default:
                    throw new IllegalArgumentException("Unknown locator strategy: " + selector);
            }
        }
        


	public WebElement locator(WebDriver driver,String locator) {
		System.out.println(  "BELOW IDS THE ANSWER !!!");	
	String val = retrieveLocatorValues(locator);
 
	  // Step 1: Remove the square brackets
	val = val.substring(0, val.length() - 1);
	
	  // Step 2: Split the string by "}, {"
    String[] array = val.split("\\}, \\{");
	
    // Step 3: Clean up any leftover curly braces
    for (int i = 0; i < array.length; i++) {
        array[i] = array[i].replaceAll("[{}]", "").trim();
    }
	
    List<String> data = new ArrayList<String>();
    // Print the resulting array 
    for (String element : array) {
      
        data.add(element);
         
    }
    String locatorElement = data.get(0).replace("[selector=", "");
    String selector = data.get(1).replace("type=", "");	
    String timeout = data.get(2).replace("timeout=", "");
    
    

   return getElement(driver, locatorElement, selector);
 
  

    }


      

}
