package ui;

import ui.page_objeckts.LoginPage;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage {

    public static void inputText(String xpath, String text) {
        $x(xpath).val(text);
    }

    public static void clickButton(String btn) {
        $x(btn).click();
    }
}
