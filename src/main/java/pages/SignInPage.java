package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-heading") WebElement pageHead;
    @FindBy (css = "button#SubmitLogin > span") WebElement signInButton;
    @FindBy (css = "input#email_create") WebElement emailTextBox;
    @FindBy (css = "button#SubmitCreate > span") WebElement createAccountButton;


    public boolean validateSignInPage(String text)  {
        return pageHead.getText().contains(text);

    }

    public boolean verifySignInButtonIsPresent() {
        return signInButton.isDisplayed();
    }

    public AccountCreationPage enterEmailAndClickCreateAccountButton(String email){
        emailTextBox.sendKeys(email);
        createAccountButton.click();
        return PageFactory.initElements(driver, AccountCreationPage.class)  ;

    }
}

