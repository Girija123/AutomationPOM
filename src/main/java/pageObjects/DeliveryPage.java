package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;

public class DeliveryPage {

    public DeliveryPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
}
