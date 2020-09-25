package modules;

import helpers.Log;
import helpers.ManagerPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import pageobjects.AutomationHomePage;
import pageobjects.LoginPage;
import step_definitions.Hooks;

import java.util.HashMap;


public class SignInAction {

    public static void Execute(WebDriver driver, HashMap<String, String> map) {

		/*
			by using pageObjectManager instance we can avoid creation a new POM every time
			it created only once and used everywhere
		 */
        AutomationHomePage automationHomePage = Hooks.managerPageObject.getAutomationHomePage();
        LoginPage loginPage = Hooks.managerPageObject.getLoginPage();

        automationHomePage.sign_in_click();
//        Log.info("Click action is performed on My Account link");

        loginPage.email_sendKeys(map.get("username"));

//        Log.info(" is entered in UserName text box");

        loginPage.password_sendKeys(map.get("password"));
//        Log.info(" is entered in Password text box");

        loginPage.signin_button_click();
//        Log.info("Click action is performed on Submit button");

        Reporter.log("SignIn Action is successfully perfomred");

    }
}
