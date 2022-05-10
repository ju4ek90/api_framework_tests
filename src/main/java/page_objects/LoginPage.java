package page_objects;

import applications.ui.CosmosIdUi;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends CosmosIdUi {

    private static final String USERNAME_FIELD = "//*[@id='email']";
    private static final String PASS_FIELD = "//*[@id='password']";
    private static final String LOGIN_BTN = "//*[@id='signInButton']";
    private static final String LOGIN_ERR = "//div[contains(.,'Password is not correct')]";
    private static final String FIRST_MESSAGE= "//button[contains(.,'Do not show again')]";

    public static void login(String login, String pass) {
        CosmosIdUi.openLoginPage();
        CosmosIdUi.clickButton(FIRST_MESSAGE);
        CosmosIdUi.inputText(USERNAME_FIELD, login);
        CosmosIdUi.inputText(PASS_FIELD, pass);
        CosmosIdUi.clickButton(LOGIN_BTN);
    }

    public static boolean isLoginFailed(String login, String pass) {
        login(login, pass);
        return  $x(LOGIN_ERR).shouldBe(Condition.visible).isDisplayed();
    }

}
