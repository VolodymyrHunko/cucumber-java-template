package step_definitions;

import Configuration.FileReaderManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.SignInAction;
import modules.SignOutAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ShoppingCart{
    public WebDriver driver;
    public List<HashMap<String,String>> dataMap;
    
    /*
        constructor executed all time before class called
     */
    public ShoppingCart() {
    	driver = Hooks.driver;
    	dataMap = new ArrayList<>();
    	HashMap<String,String> sampleData = new HashMap<String,String>();
    	sampleData.put("username","vhun0001@gmail.com");
    	sampleData.put("password","Gv$12345");
    	System.out.println("Current data: " +sampleData.toString());
    	dataMap.add(sampleData);
    }
    
    @Given("^I open automationpractice website$")
    public void i_open_automationpractice_website() throws InterruptedException {
        System.out.println("Try to open URL: "+ FileReaderManager.getInstance().getConfigFileReader().getAppURL());
    	driver.get(FileReaderManager.getInstance().getConfigFileReader().getAppURL());
        System.out.println("Title: "+driver.getTitle());
        Thread.sleep(1000);
    }

    @When("^I sign in$")
    public void i_sign_in() throws Throwable {
		SignInAction.Execute(driver,dataMap.get(0));
        Assert.assertNotNull(driver.findElement(By.cssSelector(".alert li")));
    }

    @Then("^I sign out$")
    public void i_sign_out() throws Throwable {
    	SignOutAction.Execute(driver);
    }
    
}