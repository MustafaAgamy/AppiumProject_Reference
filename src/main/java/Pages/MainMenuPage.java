package Pages;

import Pages.Animation.AnimationPage;
import Pages.Preference.PreferencePage;
import Pages.Views.ViewsPage;
import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainMenuPage extends AndroidActions {

    private final By animationBtn = AppiumBy.accessibilityId("Animation");
    private final By preferenceBtn = AppiumBy.accessibilityId("Preference");
    private final By viewsBtn = AppiumBy.accessibilityId("Views");
    public MainMenuPage(AndroidDriver driver) {
        super(driver);
    }

    public AnimationPage clickAnimationBtn(){
        findElement(animationBtn).click();
        return new AnimationPage(driver);
    }

    public ViewsPage clickViewsBtn(){
        findElement(viewsBtn).click();
        return new ViewsPage(driver);
    }
    public PreferencePage clickPreferenceBtn(){
        findElement(preferenceBtn).click();
        return new PreferencePage(driver);
    }

    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
