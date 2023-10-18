package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage {
    WebDriver driver;
    public StorePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy (xpath = "//*[@class='woocommerce-products-header__title page-title']")
    WebElement pageTitle;

    @FindBy (css = "button.single_add_to_cart_button")
    WebElement addToCartBtn;

    @FindBy (css = "a.wc-forward")
    WebElement viewCartBtn;

    public String getStorePageTitle(){
        return wait.until(ExpectedConditions.elementToBeClickable(pageTitle)).getText();
    }

    public void addProdToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
    public CartPage goToViewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
        return new CartPage(driver);
    }

}
