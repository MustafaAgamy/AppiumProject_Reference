package Pages.Views.AutoComplete;

import Pages.Views.AutoComplete.ScreenTop.ScreenTopPage;
import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutoCompletePage extends AndroidActions {
    private final By screenTopBtn = AppiumBy.accessibilityId("1. Screen Top");
    public AutoCompletePage(AndroidDriver driver) {
        super(driver);
    }

    public ScreenTopPage screenTopClick(){
        findElement(screenTopBtn).click();
        return new ScreenTopPage(driver);
    }

    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
