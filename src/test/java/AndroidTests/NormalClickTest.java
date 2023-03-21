package AndroidTests;

import Pages.MainMenuPage;
import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class NormalClickTest extends FrameworkInitialization {

    @Test
    public void normalClick() throws InterruptedException {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickAnimationBtn();
        Thread.sleep(2000);
    }
}
