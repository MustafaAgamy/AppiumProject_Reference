package Pages;

import Utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;


public class WindowsMangerPage extends AndroidActions {

    public WebDriver.Navigation navigate;
    public WindowsMangerPage(AndroidDriver driver) {
        super(driver);
        navigate = driver.navigate();
    }

    public void goBack(){
        navigate.back();
    }


}
