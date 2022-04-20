import api.ApiClient;
import conf.Config;
import org.testng.annotations.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

    @Test(description = "Verify thst the token will be returned")
    public void testLoginSuccesful() throws Exception{

        try {
            assert !ApiClient.sendLoginToGetToken().isEmpty();
        }
        catch (Exception e){
            LOGGER.error("Login Failed");
        }
    }
}
