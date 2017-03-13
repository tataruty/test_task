package SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ayumi on 13/03/2017.
 */
public class LoginForm extends Page {

    @FindBy(css="#user_login")
    private WebElement usernameField;

    @FindBy(css="#user_pass")
    private WebElement userPassField;

    @FindBy(css="#wp-submit")
    private WebElement submitBtn;

    public LoginForm (WebDriver driver){
        super(driver);
    }

    public S3groupStartPage Login(String user, String pwd){
        usernameField.sendKeys(user);
        userPassField.sendKeys(pwd);
        submitBtn.click();
        return PageFactory.initElements(driver, S3groupStartPage.class);
    }
}
