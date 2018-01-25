package step_definitions;

import com.github.javafaker.Faker;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;

public class submitionForms {
    public WebDriver driver;
    Faker faker = new Faker();
    public submitionForms(){
        driver = Hooks.driver;
    }

    @When("^I open practiceselenium website$")
    public void i_open_practiceselenium_website() {
        driver.get("http://www.practiceselenium.com/practice-form.html");
        AssertJUnit.assertEquals("practice-form", driver.getTitle());
    }

    @When("^navigate to practiceform link$")
    public void navigate_to_practiceform_link() {
        System.out.println("Open practice form link");
    }

    @When("^I fill all fields on the form and submit$")
    public void i_fill_all_fields_on_the_form_and_submit() {
        driver.findElement(By.name("firstname")).sendKeys("firstname");
        driver.findElement(By.name("lastname")).sendKeys("lastname");
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-2")).click();
        driver.findElement(By.id("datepicker")).sendKeys("1/1/2000");
        driver.findElement(By.id("tea3")).click();
        driver.findElement(By.id("tool-1")).click();
        Select continents_select = new Select(driver.findElement(By.id("continents")));
        continents_select.selectByVisibleText("Asia");
        Select another_select_list = new Select(driver.findElement(By.id("selenium_commands")));
        another_select_list.selectByVisibleText("Navigation Commands");
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I should see successfully submitted$")
    public void i_should_see_successfully_submitted() {
        AssertJUnit.assertEquals("Welcome", driver.getTitle());
    }

    @When("^I fill \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_fill(String firstname, String lastname, String sex, String yrs, String dateStopped) {
        driver.findElement(By.name("firstname")).sendKeys(firstname);
        driver.findElement(By.name("lastname")).sendKeys(lastname);
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-2")).click();
        driver.findElement(By.id("datepicker")).sendKeys(dateStopped);
    }

    @When("^I fill \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_fill_and(String tea, String excitedAbout, String continent, String seleniumCommands) {
        driver.findElement(By.id("tea3")).click();
        driver.findElement(By.id("tool-1")).click();
        Select continents_select = new Select(driver.findElement(By.id("continents")));
        continents_select.selectByVisibleText(continent);
        Select another_select_list = new Select(driver.findElement(By.id("selenium_commands")));
        another_select_list.selectByVisibleText(seleniumCommands);
    }

    @When("^I hit submit button$")
    public void i_hit_submit_button() {
        System.out.println("Do sms here...");
    }

    @Then("^I go back to Welcome page and verify title$")
    public void i_go_back_to_Welcome_page_and_verify_title() {
        System.out.println("Do sms here too.");
    }

    @When("^I fill the form with fake values$")
    public void i_fill_the_form_with_fake_values() {
        driver.findElement(By.name("firstname")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("lastname")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-2")).click();
        driver.findElement(By.id("datepicker")).sendKeys("1/1/2001");
        driver.findElement(By.id("tea3")).click();
        driver.findElement(By.id("tool-1")).click();
        Select continents_select = new Select(driver.findElement(By.id("continents")));
        continents_select.selectByVisibleText("Asia");
        Select another_select_list = new Select(driver.findElement(By.id("selenium_commands")));
        another_select_list.selectByVisibleText("Navigation Commands");
    }


}
