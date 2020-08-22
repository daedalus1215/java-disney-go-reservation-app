package config;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.of;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration file for the App.
 */
@Configuration
public final class AppConfig {

    private static final String PROPERTY_FILE = "app.properties";
    @SuppressWarnings("NullPointerException")
    private static final String RESOURCE_DIRECTORY = of(
         requireNonNull(Thread.currentThread()
              .getContextClassLoader()
              .getResource(""))
              .getPath())
         .orElse("");

    final Properties appProps = new Properties();

    public AppConfig() throws IOException {
        final String appConfigPath = RESOURCE_DIRECTORY + PROPERTY_FILE;
        this.appProps.load(new FileInputStream(appConfigPath));

    }

    public String getDatabaseUser() {
        return this.appProps.getProperty("dbUser");
    }

    public String getDbPassword() {
        return this.appProps.getProperty("dbPassword");
    }

    public String getDb() {
        return this.appProps.getProperty("db");
    }

    public String getDbHost() {
        return this.appProps.getProperty("dbHost");
    }

    public String getDbPort() {
        return this.appProps.getProperty("dbPort");
    }

    public String getEmailUsername() {
        return this.appProps.getProperty("emailUsername");
    }

    public String getEmailPassword() {
        return this.appProps.getProperty("emailPassword");
    }

    public String getRecipient() {
        return this.appProps.getProperty("recipient");
    }
}
