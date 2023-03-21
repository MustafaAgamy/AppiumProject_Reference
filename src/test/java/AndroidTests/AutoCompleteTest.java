package AndroidTests;

import Pages.MainMenuPage;
import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class AutoCompleteTest extends FrameworkInitialization {

    @Test
    public void AutoCompTest(){
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickViewsBtn()
                .autoCompleteClick()
                .screenTopClick().typeText();

    }
}
