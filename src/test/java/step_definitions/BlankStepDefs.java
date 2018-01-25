package step_definitions;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.asserts.SoftAssert;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class BlankStepDefs{
    public WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    
    public BlankStepDefs() {
        driver = Hooks.driver;
    }
    
    @When("^I open seleniumframework website$")
    public void i_open_seleniumframework_website()  {
        driver.get("http://www.seleniumframework.com");
    }

    @Then("^I validate title and URL$")
    public void i_print_title_and_URL()  {
      assertEquals("Selenium Framework | Selenium, Cucumber, Ruby, Java et al.",driver.getTitle());
      softAssert.assertEquals(driver.getCurrentUrl(), "http://www.seleniumframework.com/", "URL is: ");
    }
    
}