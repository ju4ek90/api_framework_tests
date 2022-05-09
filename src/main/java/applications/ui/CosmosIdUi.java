package applications.ui;

import page_objects.LoginPage;
import conf.Config;

import static applications.ui.Utils.PAGE_LOAD_TIMEOUT;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class CosmosIdUi {

    protected static LoginPage loginPage;

    public static void initPageObjects() {
        loginPage = new LoginPage();
    }

    public static void openLoginPage() {
        open("https://" + Config.BASE_URL.getValue() + Urls.LOGIN);
        openApp();
    }

    public static void openApp(){
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
    }

}
