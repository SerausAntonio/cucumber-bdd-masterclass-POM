package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver){
        super(driver);

    }
    @FindBy (xpath = "//*[@class='has-text-align-center']")
    WebElement billingPageTitle;

    @FindBy (id = "billing_first_name")
    WebElement firstName;

    @FindBy (id = "billing_last_name")
    WebElement lastName;

    @FindBy (id = "billing_address_1")
    WebElement adress1;

    @FindBy (xpath = "//*[@class='select2-search__field']")
    WebElement country1;
    @FindBy (xpath = "//*[@class='select2-selection select2-selection--single']")
    WebElement country;

    @FindBy (id = "billing_city")
    WebElement billingCity;

    public String getBillingPageTitle(){
        return wait.until(ExpectedConditions.elementToBeClickable(billingPageTitle)).getText();

    }

    public void typeFirstName(String name){
        firstName.sendKeys(name);
    }
    public void typeLastName(String lastname){
        lastName.sendKeys(lastname);
    }

    public void typeAdress(String adress){
        adress1.sendKeys(adress);
    }
    public void setCountry(String country1){
        country.click();
        country.sendKeys(country1);
        country.sendKeys(Keys.RETURN);
    }
    public void setBillingCity(String city){
        billingCity.sendKeys(city);
    }

}
