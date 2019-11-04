package pages.templates;

import models.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.CommonPage;
import utils.WaitUtils;

import java.util.ArrayList;
import java.util.List;

public class DraftLetterTemplatePage extends BasePage {

    List<String> letterAttributes;

    private static final String MAIL_RECIPIENT_FIELD = "//input[@class = 'container--H9L5q size_s--3_M-_' and @tabindex = '100']";
    private static final String SUBJECT_FIELD = "//input[@name='Subject']";
    private static final String CLOSE_BUTTON = "//button[@title = 'Свернуть']";
   // private static final String CLOSE_CONFIRMATION_BUTTON = "//div[@class='_nb-popup-buttons']/button[@data-action='save']";
    private static final String MAIL_BODY_FIELD = "//*[@role = 'textbox']";
    private static final String SEND_LETTER_BUTTON = "//span[contains(text(), 'Отправить')]";
    private static final String CAPTCHA_POPUP = "//div[@class='b-popup__p']]";
    private static final String CAPTCHA_INPUT_FIELD = "//input[contains(@class,'s-captcha-input')]";

    @FindBy(xpath = MAIL_RECIPIENT_FIELD)
    private WebElement mailRecipientField;

    @FindBy(xpath = SUBJECT_FIELD)
    private WebElement subjectField;

    @FindBy(xpath = MAIL_BODY_FIELD)
    private WebElement mailBodyField;

    @FindBy(xpath = CLOSE_BUTTON)
    private WebElement closeButton;


    @FindBy(xpath = SEND_LETTER_BUTTON)
    private WebElement sendLetterButton;


    public DraftLetterTemplatePage fillInLetterFields() {
        fillInLetterSubject("avsc");
        fillInLetterRecipient("denqa.test@yandex.ru");
        fillInLetterBody("anything");
        logger.info("Letter fields were filled in");
        return this;
    }

    public CommonPage closeLetterWithoutSaving() {
        closeButton.click();
        return new CommonPage();

    }

    public CommonPage sendLetter() throws InterruptedException {
        Thread.sleep(2000);
        sendLetterButton.click();
        return new CommonPage();
    }
/*
    public List<String> findLetterAttributes() {
        letterAttributes = new ArrayList<>();
        String actualSubjectValue = subjectField.getAttribute("value");
        letterAttributes.add(actualSubjectValue);

        String actualBodyValue = mailBodyField.getText();
        letterAttributes.add(actualBodyValue);
        return letterAttributes;
    }
*/
    public void fillInLetterRecipient(String letterRecipient) {
        mailRecipientField.click();
        mailRecipientField.sendKeys(letterRecipient);
    }

    public void fillInLetterSubject(String letterSubject) {
        waitForPageToBeLoaded();
        subjectField.click();
        subjectField.sendKeys(letterSubject);
    }

    public void fillInLetterBody(String letterBody) {
        mailBodyField.click();
        mailBodyField.sendKeys(letterBody);
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(CLOSE_BUTTON));
    }
}
