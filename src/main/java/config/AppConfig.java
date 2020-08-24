package config;

import java.io.IOException;
import java.util.Properties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration file for the App.
 */
@Configuration
public final class AppConfig {

    final Properties appProps = new Properties();

    /**
     * @TODO: Explain what I am doing here, the relevance if you were to pull the project down and run from scratch.
     * @throws IOException
     */
    public AppConfig() throws IOException {
        this.appProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("app.properties"));
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
