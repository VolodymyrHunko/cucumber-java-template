package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AutomationHomePage extends BaseClass {
    /*
        by using PageFactory in constructor we can avoid of using ->
        public static WebElement sign_in;
        and use private WebElements
    */
    @FindBy(how = How.LINK_TEXT, using = "Sign in")
    private WebElement sign_in;
    @FindBy(how = How.LINK_TEXT, using = "Contact us")
    private WebElement contact_us;
    @FindBy(how = How.LINK_TEXT, using = "Sign out")
    private WebElement sign_out;


    // initiate page from constructor and do not use static methods
    public AutomationHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /*
        create a set of public methods for assess to WebElements
     */
    public void sign_in_click() {
        sign_in.click();
    }
    public void sign_out_click(){
        sign_out.click();
    }

    static class HeaderPage {
        @FindBy(how = How.LINK_TEXT, using = "Women")
        private WebElement menu_women;

        @FindBy(how = How.XPATH, using = "//*a[@title='Dresses']")
        private WebElement menu_dresses;

        @FindBy(how = How.XPATH, using = "//*a[@title='T-shirts']")
        private WebElement menu_tshirts;


        static class DressesPage {
            @FindBy(how = How.XPATH, using = "//*a[@title='Summer Dresses']")
            private WebElement summer_dresses;

        }

    }

}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	