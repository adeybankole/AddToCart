package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    String websiteUrl = "http://automationpractice.com/index.php";

    public HomePage goToHomePage() {
        driver.navigate().to(websiteUrl);
        driver.manage().window().maximize();
        return PageFactory.initElements(driver, HomePage.class);

    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public SignInPage goToSignInPage() {
        driver.findElement(By.cssSelector("a[title='Log in to your customer account']")).click();
       return PageFactory.initElements(driver, SignInPage.class);

    }








}
