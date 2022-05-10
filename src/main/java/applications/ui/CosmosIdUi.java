package applications.ui;

import page_objects.LoginPage;
import conf.Config;

import static applications.ui.WebBrowsersFactory.PAGE_LOAD_TIMEOUT;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class CosmosIdUi {

    public static void openLoginPage() {
        open(Config.BASE_URL.getValue() + Urls.LOGIN);
        prepareBrowser();
    }

    public static void inputText(String xpath, String text) {
        $x(xpath).val(text);
    }

    public static void clickButton(String btn) {
        $x(btn).click();
    }

    public static void prepareBrowser() {
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
    }

}
