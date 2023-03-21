package AndroidTests;

import Pages.MainMenuPage;
import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class ScrollingTest extends FrameworkInitialization {

    @Test
    public void scrollTestAndClick() throws InterruptedException {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickViewsBtn().scrollToSeekBar().setSeekBarValue();
        Thread.sleep(2000);
    }

}
