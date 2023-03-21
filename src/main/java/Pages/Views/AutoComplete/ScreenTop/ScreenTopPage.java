package Pages.Views.AutoComplete.ScreenTop;

import Utils.AndroidActions;
import com.beust.ah.A;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScreenTopPage extends AndroidActions {
    Actions actions = new Actions(driver);
    private final By textField = By.id("edit");
    public ScreenTopPage(AndroidDriver driver) {
        super(driver);
    }

    public void typeText(){
        WebElement textFL = findElement(textField);
        textFL.sendKeys("Eg");
        textFL.sendKeys(Keys.ARROW_DOWN);
        textFL.sendKeys(Keys.ENTER);
    }
    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
