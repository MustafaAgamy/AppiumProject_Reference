package TestUtils;

import Utils.AppiumUtils;
import Utils.DriverContext;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class FrameworkInitialization {
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final Properties properties = new Properties();
    protected AndroidDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void startServer() throws IOException {
        FileInputStream fis =new FileInputStream(System.getProperty("user.dir") + "//src/main/resources/data.properties");
        properties.load(fis);
        String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress") : properties.getProperty("ipAddress");
        int port = System.getProperty("port") != null ? Integer.parseInt(System.getProperty("port")) : Integer.parseInt(properties.getProperty("port"));

        AppiumUtils.startAppiumServer(ipAddress, port);
    }
    @BeforeMethod(alwaysRun = true)
    @Parameters({"platform", "appPath"})
    public void startDriver(@Optional String platform, @Optional String appPath) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src/main/resources/data.properties");
        properties.load(fis);
        if(platform.equalsIgnoreCase("Android")){
            driver = DriverContext.getAndroidDriver(appPath);

        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Tearing down the driver ... " + "\n" + df.format(new Date()) +
                "\n----------------------------------------------------------------");
    }

    @AfterSuite(alwaysRun = true)
    public void stopServer() {
        AppiumUtils.stopAppiumServer();
    }
}
