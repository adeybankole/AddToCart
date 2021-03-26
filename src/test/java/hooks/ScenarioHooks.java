package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import infrastructure.LocalBrowserManager;
import org.openqa.selenium.WebDriver;

public class ScenarioHooks {
    private LocalBrowserManager localBrowserManager;
    protected WebDriver driver;

    @Before
    public WebDriver startTest() throws Exception {
       this.localBrowserManager = new LocalBrowserManager();
        localBrowserManager.CreateBrowser();
        return driver;
    }


    @After
    public void endTest() throws InterruptedException {
        localBrowserManager.tearDownDriver();
    }

}
