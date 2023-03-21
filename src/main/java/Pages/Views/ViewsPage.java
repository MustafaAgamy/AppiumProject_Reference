package Pages.Views;

import Pages.SeekBar.SeekBarPage;
import Pages.Views.AutoComplete.AutoCompletePage;
import Pages.Views.DragAndDrop.DragAndDropPage;
import Pages.Views.Gallery.GalleryPage;
import Pages.Views.Hover.HoverPage;
import Pages.Views.Tabs.TabsPage;
import Utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ViewsPage extends AndroidActions {
    private final By dragNDropBtn = AppiumBy.accessibilityId("Drag and Drop");
    private final By seekBarBtn = AppiumBy.accessibilityId("Seek Bar");
    private final By hoverBtn = AppiumBy.accessibilityId("Hover Events");
    private final By autoCompleteBtn = AppiumBy.accessibilityId("Auto Complete");
    private final By tabsBtn = AppiumBy.accessibilityId("Tabs");
    final By galleryBtn = AppiumBy.accessibilityId("Gallery");

    public ViewsPage(AndroidDriver driver) {
        super(driver);
    }

    public DragAndDropPage dragAndDropClick(){
        findElement(dragNDropBtn).click();
        return new DragAndDropPage(driver);
    }
    public SeekBarPage scrollToSeekBar(){
        AndroidActions.scrollToText("Seek Bar");
        findElement(seekBarBtn).click();
        return new SeekBarPage(driver);
    }

    public HoverPage hoverClick(){
        findElement(hoverBtn).click();
        return new HoverPage(driver);
    }

    public AutoCompletePage autoCompleteClick(){
        findElement(autoCompleteBtn).click();
        return new AutoCompletePage(driver);
    }

    public TabsPage tabsBtnClick(){
        scrollToText("Tabs");
        findElement(tabsBtn).click();
        return new TabsPage(driver);
    }

    public GalleryPage tabGalleryBtn(){
        findElement(galleryBtn).click();
        return new GalleryPage(driver);
    }

    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
