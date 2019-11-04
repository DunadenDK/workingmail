
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.authorization.HomePage;


public class test extends CommonConditions{



 //   protected Letter testLetter = LetterFieldsFiller.withDataFromProperty();

    @Test()

        public void loginToMailbox() throws InterruptedException {

            new HomePage()
                    .userEnterCredentials()
                    .openTemplateForWritingNewLetter()
                    .fillInLetterFields()
                    .closeLetterWithoutSaving()
                    .goToDraftsPage()
                    .openDraftLetter()
                    .sendLetter()
                    .goToSentMailFolder()
                    .openSentLetter()
                    .getLetterSubject();
            new CommonPage()
                    .exitFromCurrentMailbox()
                    ;

        }

    }





