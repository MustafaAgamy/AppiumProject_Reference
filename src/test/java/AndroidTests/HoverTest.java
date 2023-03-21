package AndroidTests;

import Pages.MainMenuPage;
import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class HoverTest extends FrameworkInitialization {

    @Test
    public void hoverTest() throws InterruptedException {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickViewsBtn()
                .hoverClick()
                .hoverToElement();
        Thread.sleep(2000);
    }
}
