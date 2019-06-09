package pageObjects;

import decorator.elements.Button;
import decorator.elements.PageElement;
import decorator.elements.TextInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.GenericArrayType;

import static consts.Constants.BusinessConfigs.HOME_PAGE_URL;

public class HomePage extends AbstractPage {

    private static final Logger LOG = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//p[@class='header-auth__signin']//span")
     private Button signInButton;

    @FindBy(className = "user-info__name")
    private PageElement topRightCornerUserNameElement;

    @FindBy(xpath = "//ul[@class='main-nav__list']//a[contains(@class,'training')]")
    private Button trainingListPageButton;

    @FindBy(className = "//ul[@class='main-nav__list']//a[contains(@class,'news')]")
    private Button newsPageButton;

    @FindBy(className = "//ul[@class='main-nav__list']//a[contains(@class,'about')]")
    private Button aboutPageButton;

    @FindBy(xpath = "//ul[@class='main-nav__list']//a[contains(@class,'faq')]")
    private Button FAQPageButton;


    public SignInPage clickSignInButton() {
        signInButton.click();
        LOG.info("'Sign in' button clicked");
        return new SignInPage();
    }

    public HomePage proceedToHomePage() {
        proceedToPage(HOME_PAGE_URL);
        LOG.info(String.format("Proceeded to '%s' URL.",HOME_PAGE_URL));
        return this;
    }

    public boolean isUserNameDisplayed(){
        boolean isDisplayed = topRightCornerUserNameElement.isDisplayed();
        LOG.info(String.format("User is logged in: '%s'",isDisplayed));
        return isDisplayed;
    }
    public String getLoggedInUserName(){
        return topRightCornerUserNameElement.getText();
    }

    public TrainingListPage openTrainingListPage() {
        trainingListPageButton.click();
        LOG.info("Open 'Training List' page.");
        return new TrainingListPage();
    }

    public NewsPage openNewsPage() {
        newsPageButton.click();
        LOG.info("Open 'News Page' page.");
        return new NewsPage();
    }

    public AboutPage openAboutPage() {
        aboutPageButton.click();
        LOG.info("Open 'About' page.");
        return new AboutPage();
    }

    public FAQPage openFAQPage() {
        FAQPageButton.click();
        LOG.info("Open 'FAQ' page.");
        return new FAQPage();
    }


}
