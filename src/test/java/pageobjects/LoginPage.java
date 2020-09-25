package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

    @FindBy(how = How.ID, using = "email")
    private WebElement email;
    @FindBy(how = How.ID, using = "passwd")
    private WebElement password;
    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement signin_button;
    @FindBy(how = How.ID, using = "email_create")
    private WebElement email_create;
    @FindBy(how = How.ID, using = "SubmitCreate")
    private WebElement submit_create;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void email_sendKeys(String key) {
        email.sendKeys(key);
    }

    public void password_sendKeys(String key) {
        password.sendKeys(key);
    }

    public void signin_button_click() {
        signin_button.click();
    }

}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
