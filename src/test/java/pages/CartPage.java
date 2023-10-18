package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    private WebDriver driver;
    public CartPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    @FindBy (css = ".count")
    WebElement cntMsg;

    @FindBy (xpath = "//td[@class='product-name']/a")
    WebElement prodName;

    @FindBy (css = "a.checkout-button")
    WebElement checkOutBtn;

    public int getCartCount(){
       return Integer.valueOf(cntMsg.getText());
    }

    public String getProdName(){
       return prodName.getText();
    }

    public CheckoutPage proceedToCheckOut(){
         checkOutBtn.click();
         return new CheckoutPage(driver);
    }

}
