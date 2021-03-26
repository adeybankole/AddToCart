package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")
    WebElement button2;




}
