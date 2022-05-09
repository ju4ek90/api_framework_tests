package applications.api;

import com.squareup.okhttp.HttpUrl;
import conf.Config;
import wiremock.net.minidev.json.JSONObject;
import wiremock.net.minidev.json.parser.JSONParser;
import wiremock.net.minidev.json.parser.ParseException;

public class CommonUtils {

    public static String getToken(String response) {

        String token;
        try {
            Object obj = new JSONParser().parse(response);
            JSONObject jo = (JSONObject) obj;
            token = (String) jo.get("token");

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return token;
    }

    public static HttpUrl buildUrl(String segment) {
          HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(Config.BASE_URL.getValue())
                .addPathSegment(segment)
                .build();

          return url;
    }
}
