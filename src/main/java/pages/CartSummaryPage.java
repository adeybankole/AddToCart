package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartSummaryPage extends BasePage {
    public CartSummaryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (css = "#center_column p:nth-child(7) span")
    WebElement proceedToCheckOut;

    public SignInPage clickCheckoutButton(){
        proceedToCheckOut.click();
        return PageFactory.initElements(driver, SignInPage.class);
    }
}
