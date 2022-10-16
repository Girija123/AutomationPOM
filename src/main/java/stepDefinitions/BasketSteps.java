package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pageObjects.BasketPage;

public class BasketSteps extends CommonFunctions {

    BasketPage basketPage = new BasketPage(driver);

    @When("I add product {string} to cart")
    public void addAProductToBag(String product)
    {
        driver.findElement(By.xpath("//div[text()='"+product+"']")).click();
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
    }

    @When("I click back to products button")
    public void clickBackToProductsBtn()
    {
        driver.findElement(By.id("back-to-products")).click();
    }

    @Then("I should see {string} in the bag with heading {string}")
    public void verifyProductInBag(String expectedProductInBag, String expectedPageHeading)
    {
        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertEquals(expectedPageHeading, driver.findElement(By.className("title")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+expectedProductInBag+"']")).isDisplayed());
    }

    @Then("I should see {string} and  {string} in the bag")
    public void verifyMultipleProductsInBag(String expectedProduct1, String expectedProduct2)
    {
        waitForTime(3);
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+expectedProduct1+"']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='"+expectedProduct2+"']")).isDisplayed());

    }

    @When("I click bag icon")
    public void i_click_bag_icon() {
        basketPage.clickCartIcon();
    }
    @When("I click remove button from the bag")
    public void i_click_remove_button_from_the_bag() {
        basketPage.clickRemoveBtn();
    }
    @Then("the product {string} should not exist in the bag")
    public void the_product_should_not_exist_in_the_bag(String expectedProduct) {
        basketPage.assertRemoveItem(expectedProduct);
    }
}
