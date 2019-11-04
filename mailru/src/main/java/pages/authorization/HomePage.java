package pages.authorization;

import driver.decorator.CustomDriverDecorator;
import models.Mailbox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CommonPage;
import service.MailboxCreator;
import utils.ElementUtils;
import utils.WaitUtils;


public class HomePage extends BasePage {

    //protected Mailbox testMailbox = MailboxCreator.withCredentialsFromProperty();

    private static final String LOGIN_INPUT = "input[name='login']" ;
    private static final String PASSWORD_INPUT = "input[id='mailbox:password']";
    private static final String PROCEED_BUTTON =  "//input[@class='o-control']";

    @FindBy(css = LOGIN_INPUT)
    private WebElement loginField;

    @FindBy(css = PASSWORD_INPUT)
    private WebElement passwordField;

    @FindBy(xpath = PROCEED_BUTTON)
    private WebElement proceedButton;


    public CommonPage userEnterCredentials ( ){
        userEntersLoginName();
       userEntersPasswordValue("S2501552s");
        logger.info("Login was performed");
  return new CommonPage();
}


    public HomePage userEntersLoginName() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.cssSelector(LOGIN_INPUT));
        driver.findElement(By.cssSelector(LOGIN_INPUT)).sendKeys("denqa.test");
        driver.findElement(By.xpath(PROCEED_BUTTON)).click();
        return this;
    }


    public HomePage userEntersPasswordValue(String mailboxPassword) {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.cssSelector(PASSWORD_INPUT));
        driver.findElement(By.cssSelector(PASSWORD_INPUT)).sendKeys(mailboxPassword);
        driver.findElement(By.xpath(PROCEED_BUTTON)).click();
        return this;
    }

    public boolean checkThatYouHaveLoggedOff() {
        return passwordField.isDisplayed();
    }

    @Override
    protected void waitForPageToBeLoaded() {
    }
}