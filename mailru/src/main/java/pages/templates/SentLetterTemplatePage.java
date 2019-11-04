package pages.templates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CommonPage;
import utils.WaitUtils;

public class SentLetterTemplatePage extends BasePage {

    private static final String FORWARD_BUTTON = "//span[contains(text(), 'Отправить')]";
    private static final String SENT_LETTER_SUBJECT = "//input[@name='Subject']";

    @FindBy(xpath = FORWARD_BUTTON)
    private WebElement forwardButton;

    @FindBy(xpath = SENT_LETTER_SUBJECT)
    private WebElement letterSubject;


    public String getLetterSubject() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(SENT_LETTER_SUBJECT));
        return letterSubject.getText();

    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(FORWARD_BUTTON));
    }
}
