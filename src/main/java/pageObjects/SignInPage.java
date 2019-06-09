package pageObjects;

import decorator.elements.Button;
import decorator.elements.PageElement;
import decorator.elements.TextInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage{

    private static final Logger LOG = Logger.getLogger(SignInPage.class);

    @FindBy(id= "signInEmail")
    private TextInput mailInput;

    @FindBy(id = "signInPassword")
    private TextInput passwordInput;

    @FindBy(className = "popup-reg-sign-in-form__sign-in")
    private Button signInButton;

    @FindBy(xpath = "//div[text()='Login failed. Please try again.']")
    private PageElement loginFailedErrorMessage;

    public SignInPage enterEmail(String email){
        mailInput.sendKeys(email);
        LOG.info("Mail was entered.");
        return this;
    }

    public SignInPage enterPassword(String password){
        passwordInput.sendKeys(password);
        LOG.info("Password was entered.");
        return this;
    }

    public  HomePage clickSignInButton(){
        signInButton.click();
        LOG.info("Sign in button clicked.");
        return new HomePage();
    }

    public boolean isLoginFailedErrorMessageDisplayed() {
        boolean isDisplayed = loginFailedErrorMessage.isDisplayed();
        LOG.info(String.format("Is 'Login Failed' error message displayed': '%s'",isDisplayed));
        return isDisplayed;
    }
}
