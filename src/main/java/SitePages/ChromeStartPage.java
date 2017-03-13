package SitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ayumi on 13/03/2017.
 */
public class ChromeStartPage  extends Page {

    @FindBy(css=".gsfi")
    private WebElement searchField;

    @FindBy(css=".sbico-c")
    private WebElement searchBtn;

    public ChromeStartPage (WebDriver driver){
        super(driver);
    }

    public ChromeResultPage FindText(String textToFind){
        searchField.sendKeys(textToFind);
        searchBtn.click();
        return PageFactory.initElements(driver, ChromeResultPage.class);
    }
}

