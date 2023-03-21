package Utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.deviceorientation.DeviceOrientation;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AndroidActions extends  AppiumUtils {
        public static AndroidDriver driver;
        private static DeviceOrientation orientation;
        protected WebDriverWait wait;

        public AndroidActions(AndroidDriver driver) {
                AndroidActions.driver = driver;
                wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        /**@Documentation of the Android Actions:
        // https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        **/


        protected static void scrollToTheEnd(int left, int top, int width, int height, String direction, double percentage) {
                boolean canScrollMore;
                do {
                        canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                                "left", left, "top", top, "width", width, "height", height,
                                "direction", direction,
                                "percent", percentage
                        ));
                } while (canScrollMore);
        }

        protected static void scrollToText(String text) {
                driver.findElement(AppiumBy.androidUIAutomator(String.format("new UiScrollable(new UiSelector()).scrollIntoView(text(\"%s\"));", text)));
        }

        protected static void doubleClickGesture(WebElement element) {
                ((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId()
                ));
        }

        protected static void longPressAction(WebElement element, int millisecondsToHold) {
                ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "duration", millisecondsToHold
                ));
        }

        protected static void clickGesture(WebElement element) {
                driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId()
                ));
        }

        protected static void swipeElement(WebElement element, String direction) {
                ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "direction", direction,
                        "percent", 0.75
                ));
        }

        protected static void dragDropElement(WebElement element, int endX, int endY) {
                ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "endX", endX,
                        "endY", endY
                ));
        }

        protected static void flingGesture(WebElement element, String direction, int pixelsPerSec) {
                boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "direction", direction,
                        "speed", pixelsPerSec
                ));
        }

        protected static void pinchOpenGesture(WebElement element, int percentage) {
                ((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "percent", percentage
                ));
        }

        protected static void pinchCloseGesture(WebElement element, int percentage) {
                ((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                        "elementId", ((RemoteWebElement) element).getId(),
                        "percent", percentage
                ));
        }

        public static void deviceRotation(int rotation){
                DeviceRotation deviceRotation = new DeviceRotation(0, 0, rotation);
                driver.rotate(deviceRotation);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }


        /**
         * For App Package And Activity on Windows:
         * 1- Make sure your device/emulator is connected
         * 2- Open CMD and Type > adb devices to check the connected devices
         * 3- Type > adb shell dumpsys window | find "mCurrentFocus", to get the App Package And Activity
         */
        public static void StartAndroidActivity(AndroidDriver driver, String packageName, String activityName) {
                Activity activity = new Activity(packageName, activityName);
                driver.startActivity(activity);
        }
}
