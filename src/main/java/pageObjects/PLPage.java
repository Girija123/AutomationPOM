package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PLPage {

    public PLPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[@data-testid='product_summary_title']")
    public List<WebElement> productNames;

    public void verifyProductRelevance(String expectedKeywordInProductName, String expectedAlternate)
    {
        for(WebElement productName : productNames)
        {
            System.out.println(productName.getText());
            Assert.assertTrue(productName.getText().contains(expectedKeywordInProductName) || productName.getText().contains(expectedAlternate));

        }
    }
}
