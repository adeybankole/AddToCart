package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-heading") WebElement pageHead;
    @FindBy (css = "button#SubmitLogin > span") WebElement signInButton;


    public boolean validateSignInPage(String text)  {
        return pageHead.getText().contains(text);

    }

    public boolean verifySignInButtonIsPresent() {
        return signInButton.isDisplayed();
    }
}

