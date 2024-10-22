package Tests;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.Yaml;

public class LocatorUtil {
    private Map<String, Map<String, String>> locators;

    public LocatorUtil() {
        Yaml yaml = new Yaml();

        // Try loading the file from the classpath
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("locators.yml")) {
        
            // Check if the file was found and loaded
            if (inputStream == null) {
                throw new FileNotFoundException("The 'locators.yml' file was not found in the classpath.");
            }

            // Load the YAML file into the Map
            locators = yaml.load(inputStream);

            // Check if the locators Map is successfully populated
            if (locators == null) {
                throw new NullPointerException("Failed to load the locators from the YAML file.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLocator(String page, String element) {
        if (locators == null) {
            throw new IllegalStateException("Locators map is not initialized. Check if the YAML file was loaded correctly.");
        }
        return locators.get(page).get(element);
    }
    
    
    
    // Helper method to get the WebElement using the locator strategy and value
    public WebElement getElement(WebDriver driver, String locator) {
    	
    	
        String[] parts = locator.split(":", 2);
        String strategy = parts[0];
        String value = parts[1];

        switch (strategy) {
            case "id":
                return driver.findElement(By.id(value));
            case "css":
                return driver.findElement(By.cssSelector(value));
            case "xpath":
                return driver.findElement(By.xpath(value));
            case "linkText":
                return driver.findElement(By.linkText(value));
            default:
                throw new IllegalArgumentException("Unknown locator strategy: " + strategy);
        }
    }
    
}


