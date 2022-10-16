package uiAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@RunWith(JUnitParamsRunner.class)
public class LoginTest {

    public static WebDriver driver;

    @Before
    public void beforeTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Assert.assertEquals("Swag Labs", driver.getTitle());
    }

    @Test
    @Parameters({
            "standard_user, secret_sauce, PRODUCTS" })
    public void verifyLoginWithValidCredentials(String validUsername, String validPassword, String expectedPageHeading)
    {
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(validUsername);
        driver.findElement(By.id("password")).sendKeys(validPassword);
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(expectedPageHeading, driver.findElement(By.className("title")).getText());
    }

    @Test
    @Parameters({
            "invalid_user, invalid_pass, Epic sadface: Username and password do not match any user in this service"})
    public void verifyLoginWithInvalidData(String invalidUsername, String invalidPassword, String loginValidationMessage)
    {
        driver.findElement(By.id("user-name")).sendKeys(invalidUsername);
        driver.findElement(By.id("password")).sendKeys(invalidPassword);
        driver.findElement(By.id("login-button")).click();
        Assert.assertEquals(loginValidationMessage, driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText());
    }

    @After
    public void afterTest()
    {
        driver.quit();
    }

    @Test
    public void dropdownTest()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://account.johnlewis.com/account-created?continueUrl=https://account.johnlewis.com/&newSignUpFlow=true");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test='allow-all']")))).click();
       new Select(driver.findElement(By.id("title"))).selectByIndex(3);

    }


}
