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
                .buildRequestWithHeaders(CommonUtils.buildUrl(Urls.FILES_V2 + "?breadcrumbs=1&offset=0&limit=1000&_=1622700773180"), "x-token", token);

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
                .buildRequestWithHeaders(CommonUtils.buildUrl(Urls.FILES_V2 + "?breadcrumbs=1&offset=0&limit=1000&folder_id=84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622700773180"), "x-token", token);
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
                .buildRequestWithHeaders(CommonUtils.buildUrl(Urls.FILES_COUNT_URL + "?folder_id=84c966d5-8dce-429d-8f92-44d5e28b1581&_=1622700773179"), "x-token", token);

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
                .buildRequestWithHeaders(CommonUtils.buildUrl(String.format(Urls.filesRunTemplate, "7f4c7326-0a4e-4b56-a8d0-8ce002191672")
                        + "?_=1622700773181"), "x-token", token);

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
                .buildRequestWithHeaders(CommonUtils.buildUrl(String.format(Urls.filesAnalysesTemplate, "437ef8e4-b595-4fd8-a2f5-64221831e925")
                        + "?filter=total&_=1622700773184"), "x-token", token);

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
                .buildRequestWithHeaders(CommonUtils.buildUrl(String.format(Urls.filesArtifactsTemplate, "437ef8e4-b595-4fd8-a2f5-64221831e925")
                        + "?_=1622700773185"), "x-token", token);

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
