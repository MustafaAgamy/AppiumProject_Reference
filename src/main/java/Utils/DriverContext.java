package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class DriverContext {

    public static AndroidDriver getAndroidDriver(String appPath) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src/main/resources/data.properties");
        properties.load(fis);
        String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : properties.getProperty("ipAddress");
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(properties.getProperty("AndroidDeviceName"));
        options.setApp(System.getProperty("user.dir") + appPath);
        options.setChromedriverExecutable(System.getProperty("user.dir") + "//src/main/resources/drivers/chromedriver");
        AndroidDriver driver = new AndroidDriver(new URL("http://" + ipAddress + ":"+ Integer.parseInt(properties.getProperty("port"))), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
