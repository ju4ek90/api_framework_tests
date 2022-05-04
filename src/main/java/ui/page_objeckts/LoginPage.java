package ui.page_objeckts;

import com.codeborne.selenide.Selenide;
import ui.BasePage;
import ui.CosmosIdUi;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private static final String USERNAME_FIELD = "//*[@id='email']";
    private static final String PASS_FIELD = "//*[@id='password']";
    private static final String LOGIN_BTN = "//*[@id='signInButton']";
    private static final String LOGIN_ERR = "//div[contains(.,'Password is not correct')]";
    private static final String FIRST_MESSAGE= "//button[contains(.,'Do not show again')]";

    public static void Login(String login, String pass) {
        CosmosIdUi.iOpenLoginPage();
        BasePage.clickButton(FIRST_MESSAGE);
        BasePage.inputText(USERNAME_FIELD, login);
        BasePage.inputText(PASS_FIELD, pass);
        BasePage.clickButton(LOGIN_BTN);
    }

    public static boolean isLoginFaild(String login, String pass) {
        Login(login, pass);
        Selenide.sleep(300);
        return  $x(LOGIN_ERR).isDisplayed();
    }

}
