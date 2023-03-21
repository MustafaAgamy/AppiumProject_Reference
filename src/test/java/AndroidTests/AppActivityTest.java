package AndroidTests;

import Pages.Views.DragAndDrop.DragAndDropPage;
import TestUtils.FrameworkInitialization;
import Utils.AndroidActions;
import org.testng.annotations.Test;

public class AppActivityTest extends FrameworkInitialization {

    @Test
    public void testAppActivity(){
        AndroidActions.StartAndroidActivity(driver,
                "io.appium.android.apis",
                "io.appium.android.apis.view.DragAndDropDemo");
        new DragAndDropPage(driver)
                .dragNDropElement();
    }
}
