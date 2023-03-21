package Pages.Views.Tabs;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TabsIDPage extends AndroidActions {

    private final By tab1 = AppiumBy.accessibilityId("tab1");
    private final By tab2 = AppiumBy.accessibilityId("tab2");
    private final By tab3 = AppiumBy.accessibilityId("tab3");

    private final By tab2Btn = By.xpath("//android.widget.FrameLayout[2]//android.widget.LinearLayout[2]");
    private final By tab3Btn = By.xpath("//android.widget.FrameLayout[2]//android.widget.LinearLayout[3]");




    public TabsIDPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean switchToTabs(){
        boolean assertion = false;
        if(findElement(tab1).isDisplayed()){
            findElement(tab2Btn).click();
                if(findElement(tab2).isDisplayed()) findElement(tab3Btn).click();
                if(findElement(tab3).isDisplayed())
                    assertion = true;
        }
        return assertion;
    }


    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
