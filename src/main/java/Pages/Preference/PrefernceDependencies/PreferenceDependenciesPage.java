package Pages.Preference.PrefernceDependencies;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PreferenceDependenciesPage extends AndroidActions {

    private final By wiFiCheckBox = By.id("android:id/checkbox");
    private final By wiFiSettings = By.xpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout");
    private final By popUpTitle = By.id("android:id/alertTitle");
    private final By wiFiNameField = By.id("android:id/edit");
    private final By oKBtn = By.id("android:id/button1");

    public PreferenceDependenciesPage(AndroidDriver driver) {
        super(driver);
    }
    public void enableWiFi(){
        if(!(findElement(wiFiCheckBox)).isSelected()){
            findElement(wiFiCheckBox).click();
        }
    }
    public void changeWiFiName(String wifiName){
        findElement(wiFiSettings).click();
        findElement(wiFiNameField).sendKeys(wifiName);
    }
    public String getPopUpText(){
        return findElement(popUpTitle).getText();
    }
    public void confirmChanges(){
        findElement(oKBtn).click();
    }


    public WebElement findElement(By by){
        var webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
