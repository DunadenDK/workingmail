package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.authorization.HomePage;
import pages.templates.DraftLetterTemplatePage;
import pages.items.DraftsPage;
import pages.items.SentMailPage;
import utils.ElementUtils;
import utils.WaitUtils;

public class CommonPage extends BasePage {

    private static final String MAILBOX_INDICATION = "//i[@id = 'PH_user-email']";

    private static final String WRITE_NEW_LETTER_BUTTON = "./descendant::span[contains(text(), 'Написать письмо')][1]";
    private static final String DRAFTS_FOLDER = "//div[contains(text(),'Черновики')]";
    private static final String SENT_MAIL_FOLDER = "//div[contains(text(),'Отправленные')]";
    private static final String ACCOUNT_SETTINGS_DROPDOWN_OPTION = "//a[@data-metric='Account settings']";
    private static final String USER_ACCOUNT_BUTTON = "//a[contains(@class,'current-account')]";
    private static final String EXIT_BUTTON = "//a[contains(@class,'item_action_exit')]";


    @FindBy(xpath = MAILBOX_INDICATION)
    private WebElement mailboxIndication;

    @FindBy(xpath = ACCOUNT_SETTINGS_DROPDOWN_OPTION)
    private WebElement accountSettings;

    @FindBy(xpath = USER_ACCOUNT_BUTTON)
    private WebElement currentAccountButton;

    @FindBy(xpath = EXIT_BUTTON)
    private WebElement exitButton;

    @FindBy(xpath = WRITE_NEW_LETTER_BUTTON)
    private WebElement writeNewLetterButton;

    @FindBy(xpath = DRAFTS_FOLDER)
    private WebElement draftsFolder;

    @FindBy(xpath = SENT_MAIL_FOLDER)
    private WebElement sentMailFolder;


    public String findTheNameOfMailboxYouAreLoggedInto() {
        return mailboxIndication.getText();
    }

    public DraftLetterTemplatePage openTemplateForWritingNewLetter() {
        writeNewLetterButton.click();
        return new DraftLetterTemplatePage();
    }

    public DraftsPage goToDraftsPage() throws InterruptedException {
        Thread.sleep(2000);
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver,By.xpath(DRAFTS_FOLDER));
        draftsFolder.click();
        return new DraftsPage();
    }

    public SentMailPage goToSentMailFolder() throws InterruptedException {
        Thread.sleep(2000);
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver,By.xpath(SENT_MAIL_FOLDER));
        sentMailFolder.click();
        refreshCurrentPage();
        return new SentMailPage();
    }

    public HomePage exitFromCurrentMailbox() {
        waitForPageToBeLoaded();
        ElementUtils.clickOnElement(driver, mailboxIndication);
        WaitUtils.waitUntilVisibilityOfElement(driver, accountSettings);
        ElementUtils.clickOnElement(driver, accountSettings);
        WaitUtils.waitUntilVisibilityOfElement(driver, currentAccountButton);
        ElementUtils.clickOnElement(driver, currentAccountButton);
        WaitUtils.waitUntilVisibilityOfElement(driver, exitButton);
        ElementUtils.clickOnElement(driver, exitButton);
        logger.info("Log out was performed");
        return new HomePage();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(MAILBOX_INDICATION));
    }

}
