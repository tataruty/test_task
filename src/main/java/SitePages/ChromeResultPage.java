package SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ayumi on 13/03/2017.
 */
public class ChromeResultPage extends Page {

    @FindBy(css="a[href='https://www.s3group.com/']")
    public WebElement resultLink;

    public ChromeResultPage (WebDriver driver){
        super(driver);
    }

    public boolean checkText(String textToCheck){
        if (resultLink.getText().matches(textToCheck))
            return true;
        else return false;
    }

    public S3groupStartPage goToSite(){
        resultLink.click();
        return PageFactory.initElements(driver, S3groupStartPage.class);
    }
}