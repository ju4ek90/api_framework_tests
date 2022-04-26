package api;

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
    private static String token = Config.LOGIN_TOKEN.getValue();


    public static String sendLoginToGetToken() {

        //Create request
        Request request = BaseRequests
                .buildRequestWithHeaders(CommonUtils.buildUrl(Urls.LOGIN), "Authorization", Config.AUTH.getValue());

        try {
            Response response = client.newCall(request).execute();
            LOGGER.info("Status code is " + response.code() + " for " + response.request().url());
            token = CommonUtils.getToken(response.body().string());
        } catch (IOException e) {
            LOGGER.error("Error. Incorrect host or some else parameters. Any response was get");
        }
        return token;
    }

    public static String filesRootFolderRequest() throws IOException {

        //Create request
        Request request = BaseRequests
                .buildRequestWithHeaders(CommonUtils.buildUrl(Urls.ROOT_FOLDER), "x-token", token);

        Response response = null;
        try {
            response = client.newCall(request).execute();
            LOGGER.info("Status code is " + response.code() + " for " + response.request().url());
        } catch (IOException e) {
            LOGGER.error("Error. Incorrect host or some else parameters. Any response was get");
        }

        return response.body().string();
    }

    public static String filesSpecificFolderRequest() throws IOException {

        //Create request
        Request request = BaseRequests
                .buildRequestWithHeaders(CommonUtils.buildUrl(Urls.SPECIFIC_FOLDER), "x-token", token);
        Response response = null;
        try {
            response = client.newCall(request).execute();
            LOGGER.info("Status code is " + response.code() + " for " + response.request().url());
        } catch (IOException e) {
            LOGGER.error("Error. Incorrect host or some else parameters. Any response was get");
        }
        return response.body().string();
    }

    public static String filesCountRequest() throws IOException {

        //Create request
        Request request = BaseRequests
                .buildRequestWithHeaders(CommonUtils.buildUrl(Urls.FILES_COUNT_URL), "x-token", token);

        Response response = null;
        try {
            response = client.newCall(request).execute();
            LOGGER.info("Status code is " + response.code() + " for " + response.request().url());
        } catch (IOException e) {
            LOGGER.error("Error. Incorrect host or some else parameters. Any response was get");
        }
        return response.body().string();
    }

    public static String filesResultsGetRunsRequest() throws IOException {

        //Create request
        Request request = BaseRequests
                .buildRequestWithHeaders(CommonUtils.buildUrl(Urls.FILES_RESULT_URL_GET_RUN), "x-token", token);

        Response response = null;
        try {
            response = client.newCall(request).execute();
            LOGGER.info("Status code is " + response.code() + " for " + response.request().url());
        } catch (IOException e) {
            LOGGER.error("Error. Incorrect host or some else parameters. Any response was get");
        }
        return response.body().string();
    }

    public static String filesResultsGetAnalysesRequest() throws IOException {
        //Create request
        Request request = BaseRequests
                .buildRequestWithHeaders(CommonUtils.buildUrl(Urls.FILES_RESULT_URL_GET_ANALYSES), "x-token", token);

        Response response = null;
        try {
            response = client.newCall(request).execute();
            LOGGER.info("Status code is " + response.code() + " for " + response.request().url());
        } catch (IOException e) {
            LOGGER.error("Error. Incorrect host or some else parameters. Any response was get");
        }
        return response.body().string();
    }

    public static String filesResultsGetArtifactsRequest() throws IOException {

        //Create request
        Request request = BaseRequests
                .buildRequestWithHeaders(CommonUtils.buildUrl(Urls.FILES_RESULT_URL_GET_ARTIFACTS), "x-token", token);

        Response response = null;
        try {
            response = client.newCall(request).execute();
            LOGGER.info("Status code is " + response.code() + " for " + response.request().url());
        } catch (IOException e) {
            LOGGER.error("Error. Incorrect host or some else parameters. Any response was get");
        }
        return response.body().string();

    }
}
