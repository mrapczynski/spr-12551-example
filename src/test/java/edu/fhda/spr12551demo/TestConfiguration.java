package edu.fhda.spr12551demo;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Spring configuration for setting up beans needed in a unit/integration testing environment.
 *
 * @version 1.0
 */
@Configuration
public class TestConfiguration {

    /* Spring beans */
    @Autowired
    Environment environment;

    /**
     * Create a test datasource that connects to a non-production database specified in the
     * external application *.conf file.
     * @return If successful, a javax.sql.DataSource object
     */
    @Bean
    @Profile("test")
    public DataSource dataSource() {
        // Define a HikariCP configuration
        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName(environment.getProperty("testing.database.dataSourceClass"));
        config.setInitializationFailFast(true);
        config.addDataSourceProperty("url", environment.getProperty("testing.database.url"));
        config.addDataSourceProperty("user", environment.getProperty("testing.database.username"));
        config.addDataSourceProperty("password", environment.getProperty("testing.database.password"));

        // Create and return the Hikari data source
        return new HikariDataSource(config);
    }

}
