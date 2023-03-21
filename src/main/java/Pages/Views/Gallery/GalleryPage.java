package Pages.Views.Gallery;

import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GalleryPage extends AndroidActions {

    private final By photosBtn = AppiumBy.accessibilityId("1. Photos");
    private final By photo = By.xpath("//android.widget.FrameLayout[2]//android.widget.ImageView[1]");
    public GalleryPage(AndroidDriver driver) {
        super(driver);
    }

    public void photosBtnClick(){
        findElement(photosBtn).click();
    }

    public boolean firstImageFocused(){
        return findElement(photo).isSelected();
    }

    public void swipeImages(){
        WebElement photos = findElement(photo);
        swipeElement(photos,"left");
    }


    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
