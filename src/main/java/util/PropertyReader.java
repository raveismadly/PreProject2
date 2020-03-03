package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    public static Properties getProperties(String filename) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(filename);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
