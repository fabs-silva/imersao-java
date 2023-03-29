import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public final class PropertiesReader {

    private static final Properties PROPERTIES;
    private static final String PROP_FILE = "local.properties";
    private PropertiesReader() {
    }

    static {
        PROPERTIES = new Properties();
        final URL props = ClassLoader.getSystemResource(PROP_FILE);
        try {
            PROPERTIES.load(props.openStream());
        } catch (IOException ex) {

            System.out.println("Erro");
        }
    }

public static String getProperty(final String name) {

    return PROPERTIES.getProperty(name);
}
}