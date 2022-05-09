package applications.api;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Request;

public class BaseRequests {

    //    """Class for calling HTTP requests"""

    public static Request buildRequest(HttpUrl url) {
        return new Request.Builder()
                .url(url)
                .addHeader("x-token", ApiClient.token)
                .build();
    }

    public static Request buildRequestWithHeaders(HttpUrl url, String headName, String headValue) {
        return new Request.Builder()
                .url(url)
                .addHeader(headName, headValue)
                .build();
    }
}
