package Pages.Views.DragAndDrop;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DragAndDropPage extends AndroidActions {
    private final By elementToDrag = By.id("drag_dot_1");
    public DragAndDropPage(AndroidDriver driver) {
        super(driver);
    }

    public void dragNDropElement(){
        WebElement element = driver.findElement(elementToDrag);
        AndroidActions.longPressAction(element,1000);
        AndroidActions.dragDropElement(element,640,691);

    }
}
