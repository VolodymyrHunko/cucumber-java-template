package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactusPage extends BaseClass {

    @FindBy(how = How.CSS, using = ".selector,.hover")
    private WebElement div_heading;
    @FindBy(how = How.ID, using = "id_contact")
    private Select subject_heading;
    @FindBy(how = How.ID, using = "email")
    private WebElement email;
    @FindBy(how = How.ID, using = "id_order")
    private WebElement order_reference;
    @FindBy(how = How.ID, using = "message")
    private WebElement message;
    @FindBy(how = How.ID, using = "submitMessage")
    private WebElement submit;
    @FindBy(how = How.CLASS_NAME, using = "alert-danger")
    private WebElement error_message;

    public ContactusPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
