package step_definitions;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import Configuration.ConfigFileReader;
import Configuration.FileReaderManager;
import helpers.ManagerPageObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks{
    public static WebDriver driver;
    public static ManagerPageObject managerPageObject;

    
    @Before (value = "~@noweb" ,order = 2) //will exclude @noweb tagged scenarios and run 2-st if several @Before
    /*
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() {
    	driver = new FirefoxDriver();
        managerPageObject = new ManagerPageObject(driver);
    	driver.manage().deleteAllCookies();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
        System.out.println("Called 'openBrowser' @Before Method...");
    }

     
    @After(value ="~@noweb",order = 0) // exclude the running after @noweb tests
    /*
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
       
        if(scenario.isFailed()) {
        try {
        	 scenario.write("Current Page URL is " + driver.getCurrentUrl());
             byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
             scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }
        
        }
        driver.quit();
        
    }
    
}