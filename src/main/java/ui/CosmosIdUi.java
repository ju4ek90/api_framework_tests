package ui;

import conf.Config;
import ui.page_objeckts.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class CosmosIdUi {

    protected static LoginPage loginPage;
    protected static BasePage basicPage;

    public static void initPageObjects() {
        basicPage = new BasePage();
        loginPage = new LoginPage();
    }

    public static void iOpenLoginPage() {
        open("https://" + Config.BASE_URL.getValue() + Urls.LOGIN);
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(200, SECONDS);
    }

}
