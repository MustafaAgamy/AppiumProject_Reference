package AndroidTests;

import Pages.MainMenuPage;
import Pages.Preference.PrefernceDependencies.PreferenceDependenciesPage;
import TestUtils.FrameworkInitialization;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeWiFiNameTest extends FrameworkInitialization {

    @Test
    public void changeWiFiTest(){
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        PreferenceDependenciesPage preferenceDependenciesPage = new PreferenceDependenciesPage(driver);
        mainMenuPage.clickPreferenceBtn()
                .prefDefBtnClick();
        preferenceDependenciesPage.enableWiFi();
        preferenceDependenciesPage.changeWiFiName("Home WiFi");

        String alertText = preferenceDependenciesPage.getPopUpText();
        Assert.assertEquals(alertText,"WiFi settings","Alert title incorrect");

        preferenceDependenciesPage.confirmChanges();
    }
}
