package helpers;

import org.openqa.selenium.WebDriver;
import pageobjects.AutomationHomePage;
import pageobjects.ContactusPage;
import pageobjects.LoginPage;

public class ManagerPageObject {
    public WebDriver driver;
    private AutomationHomePage automationHomePage;
    private ContactusPage contactusPage;
    private LoginPage loginPage;

    public ManagerPageObject(WebDriver driver){
        this.driver = driver;
    }

    public AutomationHomePage getAutomationHomePage(){
        return (automationHomePage==null)? automationHomePage=new AutomationHomePage(driver): automationHomePage;
    }
    public ContactusPage getContactusPage(){
        return (contactusPage==null)? contactusPage=new ContactusPage(driver): contactusPage;
    }
    public LoginPage getLoginPage(){
        return (loginPage==null)? loginPage=new LoginPage(driver): loginPage;
    }
}
