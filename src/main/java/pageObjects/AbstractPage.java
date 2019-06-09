package pageObjects;

import decorator.CustomDecorator;
import decorator.elements.PageElement;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    private static WebDriverWait wait =  new WebDriverWait(DriverFactory.getDriver(), 20);

    public AbstractPage() {
        PageFactory.initElements(new CustomDecorator(
                new DefaultElementLocatorFactory(DriverFactory.getDriver())
        ), this);
    }

    void  proceedToPage(final String url) {
        DriverFactory.getDriver().get(url);
    }

    protected WebElement getElement(By locator) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return webElement;
    }

    protected void waitForElementToBeVisible(PageElement pageElement){
        wait.until(ExpectedConditions.visibilityOf(pageElement));
    }

}
