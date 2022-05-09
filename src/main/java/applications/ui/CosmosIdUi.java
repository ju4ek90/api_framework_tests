package applications.ui;

import applications.page_objects.LoginPage;
import conf.Config;

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
        getWebDriver().manage().timeouts().pageLoadTimeout(200, SECONDS);
    }

}