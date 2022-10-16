package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@data-testid='header-search-bar-text-input']")
    public WebElement searchTxtFld;

    @FindBy(xpath="//button[@data-testid='header-search-bar-button']")
    public WebElement searchIcon;

    public void enterSearchTerm(String searchTerm)
    {
        searchTxtFld.sendKeys(searchTerm);
    }

    public void clickSearchIcon()
    {
        searchIcon.click();
    }


}
