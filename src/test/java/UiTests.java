import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import applications.ui.CosmosIdUi;
import applications.page_objects.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static applications.ui.Utils.webDriver;

public class UiTests {


    @BeforeClass
    public void setUp() {
        webDriver();
        CosmosIdUi.initPageObjects();
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

