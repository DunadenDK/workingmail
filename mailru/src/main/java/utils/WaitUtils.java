package utils;

import javafx.util.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class WaitUtils {
    private WaitUtils() {
    }

    public static void waitUntilVisibilityOfElementLocatedBy (WebDriver driver,By by) {
        Wait wait = new FluentWait(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(1, SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(UnhandledAlertException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitUntilVisibilityOfElement (WebDriver driver,WebElement webElement) {
        Wait wait = new FluentWait(driver)
                .withTimeout(10, SECONDS)
                .pollingEvery(1, SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(UnhandledAlertException.class);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

}
