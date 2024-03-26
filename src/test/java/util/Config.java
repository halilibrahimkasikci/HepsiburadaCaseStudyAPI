package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = Config.class.getResourceAsStream("/config.properties")) {
            properties.load(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
