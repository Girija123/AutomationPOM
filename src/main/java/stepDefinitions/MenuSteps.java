package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MenuSteps extends CommonFunctions {

    @Given("I am on home page {string}")
    public void openHomePage(String url)
    {
        driver.get(url);
        handleCookiePopup();
    }

    @When("I click on Menu option {string}")
    public void clickOnMenuOption(String menuOption)
    {
        driver.findElement(By.xpath("//a[text()='"+menuOption+"']")).click();
    }

    @Then("I should get re-directed appropriately with page heading {string}")
    public void verifyMenuReDirection(String expectedPageHeading)
    {
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='"+expectedPageHeading+"']")).isDisplayed());
    }
}
