package ui;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Utils {

    public static void webDriver() {
        Configuration.browser = Browsers.CHROME;
        Configuration.timeout = 70000;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("name", "myFramework");
        capabilities.setCapability("enableLog", true);
        capabilities.setCapability("sessionTimeout", "2m");
        Configuration.pageLoadTimeout = 70000;
        Configuration.browserCapabilities = capabilities;
    }


}
