package AndroidTests;

import Pages.MainMenuPage;
import Pages.Views.ViewsPage;
import TestUtils.FrameworkInitialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TabsTest extends FrameworkInitialization {

    @Test
    public void tabsTest(){
        MainMenuPage mainMenuPage = new MainMenuPage(driver);

        Assert.assertTrue( mainMenuPage.clickViewsBtn()
                .tabsBtnClick()
                .idBtnClick()
                .switchToTabs(),"Incorrect results");
    }
}
