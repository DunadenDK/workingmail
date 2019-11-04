import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

//@Listeners({TestListener.class})
public class CommonConditions {
    protected final Logger logger = LogManager.getRootLogger();
    WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        driver.navigate().to("https://mail.ru");
        logger.info("Login page was opened");
    }

    @AfterMethod(alwaysRun = true)
    public void terminateBrowser() {
        DriverSingleton.closeDriver();
    }
}
