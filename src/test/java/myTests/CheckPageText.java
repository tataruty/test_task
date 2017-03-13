package myTests;

import SitePages.ChromeResultPage;
import SitePages.ChromeStartPage;
import SitePages.S3groupStartPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


/**
 * Created by tusova on 2/3/2017.
 */
public class CheckPageText extends BasicTest {
    private ChromeStartPage startPage = PageFactory.initElements(getWebDriver(),SitePages.ChromeStartPage.class);
    private ChromeResultPage resultPage;
    private S3groupStartPage s3groupPage;

    @Test
    public void Login() {
        resultPage = startPage.FindText(BasicTest.conf.getTextToFind());
        assertTrue(resultPage.isTextPresent(resultPage.resultLink, BasicTest.conf.getTextToCheck()));
        s3groupPage = resultPage.goToSite();
        s3groupPage.tryToLogin(BasicTest.conf.getUser(), BasicTest.conf.getPassword());
        assertTrue(s3groupPage.checkWeAreIn());
    }


}