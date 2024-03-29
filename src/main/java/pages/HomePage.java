package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    protected Actions actions;
    @FindBy (xpath = "//div[@id='block_top_menu']/ul/li[2]/a[@title='Dresses']") WebElement dressesButton;
    @FindBy (xpath = "//div[@id='center_column']/ul/li[2]/div[@class='product-container']//div[@class='product-image-container']/a[@title='Printed Dress']/img[@alt='Printed Dress']") WebElement mostExpensive;
    @FindBy(id = "search_query_top") WebElement searchBox;
    @FindBy (css = ".button-search") WebElement searchButton;
    @FindBy (css = "#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default > span") WebElement addToCartButton;
    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a > span")
    WebElement proceedToCheckoutButton;
    @FindBy (xpath = "//div[@id='center_column']/ul/li[2]/div[@class='product-container']//a[@title='Add to cart']/span[.='Add to cart']") WebElement addToCartButton2;
    WebDriverWait wait = new WebDriverWait(driver, 10);

   public WebElement waitForElementToBeClickable(WebElement element){

       return wait.until(ExpectedConditions.elementToBeClickable(element));
   }



    public CartPage searchAndAddToCart() throws InterruptedException {

        Actions actions = new Actions(driver);
        waitForElementToBeClickable(searchBox).sendKeys("Summer dresses");
        waitForElementToBeClickable(searchButton).click();
        WebElement dressToAdd = driver.findElement(By.cssSelector(".ajax_block_product.col-md-4.col-sm-6.col-xs-12.first-in-line.first-item-of-mobile-line.first-item-of-tablet-line > .product-container > .left-block > .product-image-container > a[title='Printed Summer Dress'] > img[alt='Printed Summer Dress']"));
        actions.moveToElement(dressToAdd).perform();
        waitForElementToBeClickable(addToCartButton).click();
        return PageFactory.initElements(driver, CartPage.class);


    }

    public CartSummaryPage clickProceedCheckoutOnModalPopup() throws InterruptedException {

        waitForElementToBeClickable(proceedToCheckoutButton).click();
       return PageFactory.initElements(driver, CartSummaryPage.class);
    }

    public boolean validateItem() {
        return driver.getPageSource().contains("Product successfully added to your shopping cart");
    }


    public HomePage clickDressesMenu() {
       dressesButton.click();
       return PageFactory.initElements(driver, HomePage.class);
    }

    public CartPage addMostExpensiveDressToCart() {
        Actions actions = new Actions(driver);
        WebElement dressToAdd2 = driver.findElement(By.xpath("//div[@id='center_column']/ul/li[2]/div[@class='product-container']//div[@class='product-image-container']/a[@title='Printed Dress']/img[@alt='Printed Dress']"));
        actions.moveToElement(dressToAdd2).perform();
        waitForElementToBeClickable(addToCartButton2).click();
        return PageFactory.initElements(driver, CartPage.class);

    }
}
