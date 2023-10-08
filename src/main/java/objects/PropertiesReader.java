package objects;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public Properties properties = new Properties();

    public PropertiesReader(String test_properties) {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/java/test_properties/" + test_properties);
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
