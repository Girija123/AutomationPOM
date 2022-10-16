package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.HomePage;
import pageObjects.PLPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SearchSteps extends CommonFunctions {

    HomePage homePage = new HomePage(driver);
    PLPage plPage = new PLPage(driver);

    @Given("I am on Next Home Page {string}")
    public void i_am_on_next_home_page(String url) {
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("onetrust-accept-btn-handler")))).click();

    }
    @When("I enter search term {string}")
    public void i_enter_search_term(String searchTerm) {
        homePage.enterSearchTerm(searchTerm);
        homePage.clickSearchIcon();
    }
    @Then("I should be provided with products relevant to keywords {string} or {string}")
    public void i_should_be_provided_with_products_relevant_to_keyword(String expectedKeywordInProductName, String expectedAlternate) {
        plPage.verifyProductRelevance(expectedKeywordInProductName, expectedAlternate);
    }
}
