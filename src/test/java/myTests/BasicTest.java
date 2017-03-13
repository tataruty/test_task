package myTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by tusova on 2/20/2017.
 */
public class BasicTest {
    protected static WebDriver driver;
    protected static Utils.Configuration conf;
    private static String baseUrl;

    protected WebDriver getWebDriver(){
        conf = Utils.Configuration.INSTANCE;
        conf.loadProperties("test.properties", false);
        baseUrl = conf.getAppUrl();
        System.setProperty("webdriver.chrome.driver", conf.getDriverPath());

        if (driver == null){
            driver= new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.navigate().to(conf.getAppUrl());
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        }
        return driver;

    }

    @AfterTest
    public  void tearDown() throws Exception{
        driver.quit();
    }

}
