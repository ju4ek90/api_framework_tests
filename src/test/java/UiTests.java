import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page_objects.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static applications.ui.WebBrowsersFactory.initWebDriver;

public class UiTests {


    @BeforeClass
    public void setUp() {
        initWebDriver();
    }


    @Test(description = "Test user can not login with wrong creds")
    public void testLoginFailed() {

        assert LoginPage.isLoginFailed("kjhk@kjhk.com", "hkjljk");

    }

    @AfterClass
    public void tear_down() {
        getWebDriver().close();
    }
}

