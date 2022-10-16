package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CommonFunctions {


    @Given("I am on home page")
    public void i_am_on_home_page() {
      driver.get("");
    }
    @When("I click checkout link")
    public void i_click_checkout_link() {

    }
    @Then("I should be on checkout")
    public void i_should_be_on_checkout() {
    }
}
