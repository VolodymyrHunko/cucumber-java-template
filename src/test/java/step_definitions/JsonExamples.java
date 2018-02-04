package step_definitions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import modules.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JsonExamples {
    public WebDriver driver;
    private String json;

    public JsonExamples() {
        driver = Hooks.driver;
    }

    //create JSON file by using Gson library
    @When("^I create json string from object and write to file$")
    public void i_create_json_string_from_object_and_write_to_file() throws Throwable {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Volodymyr");
        employee.setLastName("Hunko");
        employee.setRoles(Arrays.asList("ADMIN", "QA Engineer"));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileOutputStream fout = new FileOutputStream("output.json");
        fout.write(gson.toJson(employee).getBytes());
        fout.flush();
        fout.close();
        System.out.println("JSON file named as output.json was created.");
    }

    //convert the JSON file in String by using Gson
    @Then("^I print it as a string$")
    public void i_print_it_as_a_string() throws Throwable {
        FileInputStream fin = new FileInputStream(new File("output.json"));
        InputStreamReader in = new InputStreamReader(fin);
        BufferedReader bufferedReader = new BufferedReader(in);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        json = sb.toString();
        System.out.println("String og JSON file is: "+json);
        Gson gson = new Gson();
        Employee employee = gson.fromJson(json, Employee.class);
		System.out.println("First name is: "+employee.getFirstName());
    }

    //read the JSON file
    @When("^I read json string from a file$")
    public void i_read_json_string_from_a_file() throws Throwable {
        File jsonfile = new File(System.getProperty("user.dir") + "//src//test//resources//testData//simple.json");
        FileInputStream fin = new FileInputStream(jsonfile);
        InputStreamReader in = new InputStreamReader(fin);
        BufferedReader bufferedReader = new BufferedReader(in);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        json = sb.toString();
        System.out.println("JSON file is: "+json);
    }

    //parse the JSON file by using JsonObject
    @Then("^I parse the string and print keys and values$")
    public void i_parse_the_string_and_print_keys_and_values() throws Throwable {
        JsonParser parser = new JsonParser();
        JsonObject myobject = (JsonObject) parser.parse(json);

        //Accessing the value of "desc"
        System.out.println("Description is: "+myobject.get("description"));

        //Decentralizing the value into JSONObject
        JsonObject descValue = (JsonObject) myobject.get("description");

        // Printing the someKey value using JsonObject
        System.out.println("SomeKey Value--" + descValue.get("someKey"));

        // Retrieving the JSON Element -- JsonElement can represent a string, array or other data types
        JsonElement someElement = descValue.get("someKey");
        // Printing a value again
        System.out.println("SomeKey Value--" + someElement.getAsString());
    }

    @When("^I open practice website$")
    public void i_open_practiceselenium_website() throws Throwable {
        driver.get("http://www.practiceselenium.com/practice-form.html");
    }

    @When("^I read the json data file \"(.*?)\"$")
    public void i_read_the_json_data_file(String arg1) throws Throwable {
        File newfile = new File(System.getProperty("user.dir") + "//src//test//resources//testData//" + arg1);
        FileInputStream fin = new FileInputStream(newfile);
        InputStreamReader in = new InputStreamReader(fin);
        BufferedReader bufferedReader = new BufferedReader(in);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        json = sb.toString();
        System.out.println("JSON file toString is: "+json);
    }

    @When("^I fill the form with data from json and submit$")
    public void i_fill_the_form_with_data_from_json_and_submit() throws Throwable {
        JsonParser parser = new JsonParser();
        JsonObject myobject = (JsonObject) parser.parse(json);
        JsonArray myarray = myobject.get("table").getAsJsonArray();

        //get the first section in file
        JsonObject pradeep = myarray.get(0).getAsJsonObject();

        driver.findElement(By.name("firstname")).sendKeys(pradeep.get("firstname").getAsString());
        driver.findElement(By.name("lastname")).sendKeys(pradeep.get("lastname").getAsString());
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-2")).click();

        driver.findElement(By.id("datepicker")).sendKeys(pradeep.get("date_stopped").getAsString());
        driver.findElement(By.id("tea3")).click();
        driver.findElement(By.id("tool-1")).click();

        Select continents_select = new Select(driver.findElement(By.id("continents")));
        continents_select.selectByVisibleText(pradeep.get("continent").getAsString());

        Select another_select_list = new Select(driver.findElement(By.id("selenium_commands")));
        another_select_list.selectByVisibleText(pradeep.get("selenium_commands").getAsString());

        driver.findElement(By.id("submit")).click();
        System.out.println("Title is: "+driver.getTitle());
        AssertJUnit.assertEquals("Welcome", driver.getTitle());
    }
}