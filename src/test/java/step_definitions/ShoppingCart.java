package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import modules.SignInAction;
import modules.SignoutAction;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.AutomationHomePage;
import pageobjects.LoginPage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ShoppingCart{
    public WebDriver driver;
    public static List<HashMap<String,String>> datamap;
    
    
    public ShoppingCart() {
    	driver = Hooks.driver;
    	datamap = new ArrayList<>();
    	HashMap<String,String> sampleData = new HashMap<String,String>();
    	sampleData.put("username","vhun0001@gmail.com");
    	sampleData.put("password","Gv$12345");
    	System.out.println("Current data: " +sampleData.toString());
    	datamap.add(sampleData);
    }
    
    @Given("^I open automationpractice website$")
    public void i_open_automationpractice_website() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
    	driver.get("http://automationpractice.com");
        System.out.println("Title: "+driver.getTitle());
        Thread.sleep(1000);
    }

    @When("^I sign in$")
    public void i_sign_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	PageFactory.initElements(driver, AutomationHomePage.class);
		PageFactory.initElements(driver, LoginPage.class);

		SignInAction.Execute(driver,datamap.get(0));

        Assert.assertNull(driver.findElement(By.cssSelector(".alert li")));
    }

    @Then("^I sign out$")
    public void i_sign_out() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	SignoutAction.Execute(driver);
    }
    
}