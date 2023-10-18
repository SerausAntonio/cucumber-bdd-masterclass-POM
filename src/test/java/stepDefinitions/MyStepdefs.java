package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.StorePage;

public class MyStepdefs {
    private WebDriver driver;
    StorePage storePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    @Given("I am on the store page")
    public void iAmOnTheStorePage() {
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://askomdch.com/store");
        storePage = new StorePage(driver);
        String title = storePage.getStorePageTitle();
        Assert.assertTrue(title.equals("Store"));

    }

    @When("I add a {string} to the Cart")
    public void iAddAToTheCart(String product) {
        driver.findElement(By.xpath("//*[text()='" + product + "']")).click();
        storePage.addProdToCart();

    }

    @Then("I see {int} {string} in the Cart")
    public void iSeeInTheCart(int count,  String product) {
       cartPage = storePage.goToViewCart();
       Assert.assertEquals(cartPage.getCartCount(),count);
       Assert.assertTrue(cartPage.getProdName().equals(product));

       checkoutPage = cartPage.proceedToCheckOut();
        System.out.println(checkoutPage.getBillingPageTitle());
        Assert.assertTrue(checkoutPage.getBillingPageTitle().equals("Checkout"));
        checkoutPage.typeFirstName("Charles");
        checkoutPage.typeLastName("Baker");
        checkoutPage.setCountry("Virgin Islands (US)");
        checkoutPage.typeAdress("SunsetBoulevard");
        checkoutPage.setBillingCity("New-York");
    }
}
