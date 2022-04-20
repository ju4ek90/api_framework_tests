package api;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import conf.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ApiClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);
    private static final OkHttpClient client = new OkHttpClient();

    public static String sendLoginToGetToken() {
        String token = Config.LOGIN_TOKEN.getValue();
        
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(Config.BASE_URL.getValue())
                .addPathSegment(Urls.LOGIN)
                .build();


        //Create request
        Request request = BaseRequests
                .buildRequestWithHeaders(url, "Authorization", Config.AUTH.getValue());

        try {
            Response response = client.newCall(request).execute();
            LOGGER.info("Status code is " + response.code() + " for " + response.request().url());
            token = CommonUtils.getToken(response.body().string());
            LOGGER.info(token);
        } catch (IOException e) {
            LOGGER.error("Error. Incorrect host or some else parameters. Any response was get");
        }
        return token;
    }


}
