package applications.ui;

import com.codeborne.selenide.Configuration;
import conf.Config;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Utils {

    public static void webDriver() {

        Configuration.browser = Config.BROWSER.getName();
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
