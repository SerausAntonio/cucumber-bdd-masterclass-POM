package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        return pageTitle.getText();
    }

    public void addProdToCart(){
        addToCartBtn.click();

    }
    public CartPage goToViewCart(){
        viewCartBtn.click();
        return new CartPage(driver);
    }

}
