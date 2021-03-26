package infrastructure;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocalBrowserManager {

    protected static WebDriver driver;

    public WebDriver CreateBrowser(){
        createChromeBrowser();
        return driver;
    }

    public void createChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--disable-infobars");
        options.addArguments("--incognito");
        options.addArguments("--enable-javascript");
        options.addArguments("--disable-websecurity");
        options.addArguments("--start-maximised");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--fast-start");
        options.addArguments("--javascript-harmony");
        options.addArguments("--no-sandbox");
        options.setAcceptInsecureCerts(true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        driver = new ChromeDriver(options);
    }

    public void tearDownDriver() {
        if (driver != null)
            driver.quit();
    }
}
