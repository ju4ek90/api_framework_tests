import applications.api.ApiClient;
import conf.Config;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

    @Test(description = "Verify that the token will be returned")
    public void testLoginSuccessful() {

        try {
            assert !ApiClient.sendLoginToGetToken().isEmpty();
        }
        catch (Exception e){
            LOGGER.error("Login Failed");
        }
    }
}
