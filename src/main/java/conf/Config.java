package conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Config {

//     """Class defines all the configuration for test framework"""

    BASE_URL("base.url"),
    LOGIN_TOKEN("login.token"),
    AUTH("auth"),

    ENV("app"),

    BROWSER("Chrome");

    static Properties properties = new Properties();
    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

    static {

        String mainPropertiesFileName = "properties/properties";

        ENV.name = Optional.ofNullable(System.getProperty("environment"))
                .orElse(ENV.name);
        LOGGER.info("Running in environment: {}", ENV.name);
        String envPropertiesFileName = String.format("properties/%s.properties", ENV.name);

        try (
                InputStream envInput = Config.class.getClassLoader().getResourceAsStream(envPropertiesFileName)
        ) {
            /* Properties.load() does not delete existing entries */
            properties.load(envInput);

            /*
             * Try to find property value in application properties files. Can be overridden by system properties.
             */
            for (Config property : Config.values()) {
                property.value = Optional.ofNullable(System.getProperty(property.name))
                        .orElseGet(() -> properties.getProperty(property.name));
            }

        } catch (IOException | NullPointerException e) {
            LOGGER.error("Could not load properties from {}", envPropertiesFileName, e);
        }
    }

    String value;
    String name;

    Config(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}

