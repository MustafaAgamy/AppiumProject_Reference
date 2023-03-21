package AndroidTests;

import Pages.MainMenuPage;
import Pages.Views.Gallery.GalleryPage;
import TestUtils.FrameworkInitialization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipeTest extends FrameworkInitialization {

    @Test
    public void swipePhotosTest(){
        MainMenuPage mainMenuPage = new MainMenuPage(driver);
        GalleryPage galleryPage = new GalleryPage(driver);

        mainMenuPage.clickViewsBtn()
                .tabGalleryBtn()
                .photosBtnClick();

        Assert.assertTrue(galleryPage.firstImageFocused());

        galleryPage.swipeImages();

        Assert.assertFalse(galleryPage.firstImageFocused());

    }
}
