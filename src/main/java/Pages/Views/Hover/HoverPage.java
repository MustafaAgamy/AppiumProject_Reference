package Pages.Views.Hover;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage extends AndroidActions {
    Actions actions = new Actions(driver);
    private final By checkBox = AppiumBy.accessibilityId("Make container intercept hover events");
    private final By hoverBtn = AppiumBy.accessibilityId("Hover Here");
    public HoverPage(AndroidDriver driver) {
        super(driver);
    }

    public void checkBoxClick(){
        driver.findElement(checkBox).click();
    }

    public void hoverToElement(){
        WebElement hoverHereBtn = driver.findElement(hoverBtn);
        actions.moveToElement(hoverHereBtn).perform();
    }

}
