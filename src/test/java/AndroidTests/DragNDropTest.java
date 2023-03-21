package AndroidTests;

import Pages.MainMenuPage;
import TestUtils.FrameworkInitialization;
import org.testng.annotations.Test;

public class DragNDropTest extends FrameworkInitialization {

    @Test
    public void dragDropTest() throws InterruptedException {
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.clickViewsBtn().dragAndDropClick().dragNDropElement();
        Thread.sleep(2000);
    }
}
