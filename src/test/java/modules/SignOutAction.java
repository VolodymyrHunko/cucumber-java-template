package modules;

import helpers.Log;

import helpers.ManagerPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import pageobjects.AutomationHomePage;
import step_definitions.Hooks;


public class SignOutAction {

	public static void Execute(WebDriver driver) throws Exception{

		ManagerPageObject pageObjectManager = Hooks.managerPageObject;
		AutomationHomePage automationHomePage = pageObjectManager.getAutomationHomePage();
		
		automationHomePage.sign_out_click();
//		Log.info("Sign out is performed");

		Reporter.log("Sign out is performed");

	}
}
