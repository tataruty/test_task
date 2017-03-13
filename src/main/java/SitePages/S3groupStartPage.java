package SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by tusova on 2/20/2017.
 */
public class S3groupStartPage extends Page {

    @FindBy(xpath="//*[@id='main-nav']/ul/li[1]")
    public WebElement leftLink;

    @FindBy(xpath="//*[@id='main-nav']/ul/li[2]")
    public WebElement rightLink;


    public S3groupStartPage(WebDriver driver){
        super(driver);
    }


    public S3groupStartPage tryToLogin(String user, String pass){
        if (leftLink.getText().matches("Logout"))
            leftLink.click();

        if (rightLink.getText().matches("Login"))
        {
            rightLink.click();
            LoginForm lForm = PageFactory.initElements(driver, SitePages.LoginForm.class);
            return lForm.Login(user, pass);

        }
        else return PageFactory.initElements(driver, SitePages.S3groupStartPage.class);
    }

    public boolean checkWeAreIn(){
        if (leftLink.getText().matches("Logout")) {
            System.out.println("PASS: we are in");
            return true;
        }
        else{
            System.out.println("FAIL: we are NOT in!!");
            return false;
        }
    }

}
