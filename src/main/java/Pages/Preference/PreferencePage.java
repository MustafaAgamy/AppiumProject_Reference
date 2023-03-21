package Pages.Preference;

import Pages.Preference.PrefernceDependencies.PreferenceDependenciesPage;
import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PreferencePage extends AndroidActions {

    private final By prefDepBtn = AppiumBy.accessibilityId("3. Preference dependencies");
    public PreferencePage(AndroidDriver driver) {
        super(driver);
    }

    public PreferenceDependenciesPage prefDefBtnClick(){
        findElement(prefDepBtn).click();
        return new PreferenceDependenciesPage(driver);
    }

    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
