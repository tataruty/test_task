package SitePages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by tusova on 2/20/2017.
 */
public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver){
        this.driver=driver;
    }

    public boolean isTextPresent(WebElement element, String text){
        try {
            if (element.getText().equals(text)){
                System.out.println(String.format("text \" %s \" found and equal", text));
                return  true;
            }
            else {
                System.out.println("NOT FOUND TEXT");
                return false;
            }
        } catch (NoSuchElementException ex){
            System.out.println("NO SUCH ELEMENT");
            return false;
        }
    }
}
