package Pages.Views.Tabs;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TabsPage extends AndroidActions {
    private final By contentIDBtn = AppiumBy.accessibilityId("1. Content By Id");
    public TabsPage(AndroidDriver driver) {
        super(driver);
    }

    public TabsIDPage idBtnClick(){
        findElement(contentIDBtn).click();
        return new TabsIDPage(driver);
    }

    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
