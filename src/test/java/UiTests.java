import api.ApiClient;
import conf.Config;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.CosmosIdUi;
import ui.page_objeckts.LoginPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ui.Utils.webDriver;

public class UiTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);


    @BeforeClass
    public void setUp() {
        webDriver();
        CosmosIdUi.initPageObjects();
    }


    @Test(description = "Test user can not login with wrong creds")
    public void testLoginFailed() {

        assert LoginPage.isLoginFaild("kjhk@kjhk.com", "hkjljk");

    }

    @AfterClass
    public void tear_down() {
        getWebDriver().close();
    }
}

