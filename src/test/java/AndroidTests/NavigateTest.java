package AndroidTests;

import Pages.MainMenuPage;
import Pages.WindowsMangerPage;
import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class NavigateTest extends FrameworkInitialization {

    @Test
    public void navigateHoverThenDropTest(){
        WindowsMangerPage windowsMangerPage = new WindowsMangerPage(driver);
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickViewsBtn()
                .hoverClick();
        windowsMangerPage.goBack();
        windowsMangerPage.goBack();
        mainMenuPage.clickViewsBtn()
                .dragAndDropClick();
        windowsMangerPage.goBack();
        windowsMangerPage.goBack();
    }
}
