package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    //driver.findElement(By.xpath(""));

    @FindBy(id="user-name")
    public WebElement usernameTxtFld;

    @FindBy(name="password")
    public WebElement passwordTxtFld;

    @FindBy(id="login-button")
    public WebElement loginBtn;

    @FindBy(xpath="//h3[@data-test='error']")
    public WebElement validationLoginMsgArea;

    public void verifyLoginPageLanding(String expectedTitleText)
    {
        //Assert.assertEquals();
    }

    public void enterUsername(String usernameVal)
    {
        usernameTxtFld.sendKeys(usernameVal);
    }

    public void enterPassword(String passwordVal)
    {
        passwordTxtFld.sendKeys(passwordVal);
    }

    public void clickLoginBtn()
    {
        loginBtn.click();
    }

    public void verifyInvalidLogin(String validationMsg)
    {
        Assert.assertEquals(validationMsg, validationLoginMsgArea.getText());
    }

}
