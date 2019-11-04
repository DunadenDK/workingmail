package pages.items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.templates.DraftLetterTemplatePage;
import utils.ElementUtils;
import utils.WaitUtils;

public class DraftsPage extends BasePage {

    private static final String DRAFT_LETTER = "//*[@class='llc__content']";

    @FindBy(xpath = DRAFT_LETTER)
    private WebElement draftLetter;


    public DraftLetterTemplatePage openDraftLetter() {
        waitForPageToBeLoaded();
        //ElementUtils.clickOnElement(driver, draftLetter);
        driver.findElement(By.xpath(DRAFT_LETTER)).click();
        logger.info("Draft letter was opened");
        return new DraftLetterTemplatePage();
    }

    @Override
    protected void waitForPageToBeLoaded() {
        WaitUtils.waitUntilVisibilityOfElementLocatedBy(driver, By.xpath(DRAFT_LETTER));
    }
}
