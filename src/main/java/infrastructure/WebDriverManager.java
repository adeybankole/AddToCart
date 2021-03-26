package infrastructure;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

    public WebDriver driver;
    String placeOfExecution = "LOCAL";

    public WebDriver webDriverExecution(){
        if(placeOfExecution.equalsIgnoreCase("LOCAL")) {
            LocalBrowserManager localBrowserManager = new LocalBrowserManager();
            localBrowserManager.CreateBrowser();
        }else if (placeOfExecution.equalsIgnoreCase("remote")){

        }return driver;
    }
}
