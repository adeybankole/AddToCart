package support;

import infrastructure.LocalBrowserManager;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class WorldHelper extends LocalBrowserManager {

    private BasePage basePage;


    public BasePage getBasePage() {
        if (basePage != null) return basePage;
        LocalBrowserManager localBrowserManager = new LocalBrowserManager();
        return PageFactory.initElements(driver, BasePage.class);
    }

}
