package maven;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties prop = new Properties();

        try (InputStream resourceAsStream = TestMaven.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            prop.load(Objects.requireNonNull(resourceAsStream));
        } catch (IOException ex) {
            System.err.println("Unable to load properties file: " + "config.properties");
        }

        String prop1 = (String)prop.get("props.local.hello");
        Object prop2 = prop.get("props.mvn.hello");

        System.out.println(prop1);
        System.out.println(prop2);
    }
}
