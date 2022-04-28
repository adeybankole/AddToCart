package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPage {
    @FindBy(css = "#id_gender1")
    WebElement mrRadioButton;
    @FindBy(css = "#id_gender2")
    WebElement mrsRadioButton;


    public void selectTitle(String title) {

        if (title.equals("Mr")) {
            mrRadioButton.click();
        } else {
            mrsRadioButton.click();
        }
    }
}