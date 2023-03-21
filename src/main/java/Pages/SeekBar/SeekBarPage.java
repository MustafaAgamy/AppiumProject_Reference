package Pages.SeekBar;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeekBarPage extends AndroidActions {

    private final By seekBar = By.id("seek");
    public SeekBarPage(AndroidDriver driver) {
        super(driver);
    }

    public void setSeekBarValue(){
        WebElement bar = driver.findElement(seekBar);
        AndroidActions.swipeElement(bar,"right");
    }
}
