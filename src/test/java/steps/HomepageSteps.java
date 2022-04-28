package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.AccountCreationPage;
import pages.CartSummaryPage;
import pages.HomePage;
import pages.SignInPage;
import support.WorldHelper;

public class HomepageSteps {

    WorldHelper worldHelper;
    private HomePage homePage;
    private CartSummaryPage cartSummaryPage;
    private SignInPage signInPage;
    private AccountCreationPage accountCreationPage;


    String message = "Product successfully added to your shopping cart";
    public HomepageSteps(WorldHelper worldHelper) {
        this.worldHelper = worldHelper;
    }


    @Given("^I am on website$")
    public void iAmOnWebsite() throws Throwable {
        homePage = worldHelper.getBasePage().goToHomePage();
    }

    @When("^I search for Summer dress and add item to cart$")
    public void iSearchForSummerDressAndAddItemToCart() throws Throwable {
      homePage.searchAndAddToCart();
    }

    @Then("^I should see summer dress in the cart$")
    public void iShouldSeeSummerDressInTheCart() throws Throwable {
       boolean res = homePage.validateItem();
        Assert.assertTrue(res);
    }


    @And("^I click the proceed to checkout button on the modal pop up$")
    public void iClickTheProceedToCheckoutButtonOnTheModalPopUp() throws InterruptedException {
       cartSummaryPage = homePage.clickProceedCheckoutOnModalPopup();
    }
    @And("^i click the proceed to checkout button on the cart summary page$")
    public void iClickTheProceedToCheckoutButtonOnTheCartSummaryPage() {
      signInPage =  cartSummaryPage.clickCheckoutButton();
    }



    @And("^i verify that i am on the sign in page and page title is \"([^\"]*)\"$")
    public void iVerifyThatIAmOnTheSignInPageAndPageTitleIs(String signInPageTitle) throws Throwable {
            Assert.assertTrue(signInPage.verifySignInButtonIsPresent());
            Assert.assertEquals(signInPage.getPageTitle(),signInPageTitle);
    }

    @And("^I click on Sign In$")
    public void iClickOnSignIn() {
       signInPage = homePage.goToSignInPage();



    }

    @And("^I type my email address \"([^\"]*)\" and click on create account button$")
    public void iTypeMyEmailAddressAndClickOnCreateAccountButton(String email) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       accountCreationPage = signInPage.enterEmailAndClickCreateAccountButton(email);


    }

    @And("^I select \"([^\"]*)\"$")
    public void iSelect(String title) throws Throwable {

    {
        accountCreationPage.selectTitle(title);
    }
    }

    @When("^I click on the dresses menu$")
    public void iClickOnTheDressesMenu() {
        homePage.clickDressesMenu();
    }

    @And("^I add the most expensive dress to cart$")
    public void iAddTheMostExpensiveDressToCart() {
        homePage.addMostExpensiveDressToCart();
    }

    @Then("^i should see validate item added to cart$")
    public void iShouldSeeValidateItemAddedToCart() {
        homePage.validateItem();
    }
}
