package AndroidTests;

import Pages.MainMenuPage;
import TestUtils.FrameworkInitialization;
import Utils.AndroidActions;
import org.testng.annotations.Test;

public class RotationTest extends FrameworkInitialization {

    @Test
    public void rotateDeviceTest() {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickViewsBtn()
                .scrollToSeekBar();
        AndroidActions.deviceRotation(90);


    }
}
