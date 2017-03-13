package Utils;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

import java.util.Iterator;


/**
 * Created by tusova on 2/3/2017.
 */
public class Configuration {

    private CompositeConfiguration config;

    public final static Configuration INSTANCE = new Configuration();


    private Configuration() {
        config = new CompositeConfiguration();
        //system is first, it will override other properties
        config.addConfiguration(new SystemConfiguration());
        loadProperties("test.properties", false);
        //logConfig();
    }

    public String getString(String key) {
        return config.getString(key);
    }
    /**
     * load new properties to the configuration.
     * @param isOverride true to override existing properties, false otherwise.
     * @param propertiesFile the properties file to load
     */
    public void loadProperties(String propertiesFile, boolean isOverride) {
        try {
            if (isOverride) {
                final PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration(propertiesFile);
                final Iterator<String> keys = propertiesConfiguration.getKeys();
                while (keys.hasNext()) {
                    final String key = keys.next();
                    final String value = propertiesConfiguration.getProperty(key).toString();
                    config.setProperty(key, value);
                }
            }
            else {
                config.addConfiguration(new PropertiesConfiguration(propertiesFile));
            }
        } catch (ConfigurationException e) {
            throw new RuntimeException("can't load configuration. " + e.getMessage(), e);
        }
        //logConfig();
    }


    public String getDriverPath() {
        return getString("driver.path");
    }

    public String getAppUrl() {
        return getString("app.url");
    }

    public String getTextToCheck() {
        return getString("text.to.check");
    }

    public String getTextToFind() {
        return getString("text.to.find");
    }

    public String getUser() {
        return getString("test.usermail");
    }

    public String getPassword() {
        return getString("test.userpass");
    }
}
