package edu.fhda.spring;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import edu.fhda.spring.util.DoNotModify;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.io.File;

/**
 * Utility class that configures a new Spring context with various additional features such as externalized
 * configuration prior to processing bean definitions.
 *
 * @author mrapczynski, Foothill-De Anza College District, rapczynskimatthew@fhda.edu
 * @version 1.0
 */
@DoNotModify
public class ExternalConfigurationLoader {

    public static void apply(ApplicationContext context) {
        // Get application.conf off the class path
        Config appConfig = ConfigFactory.parseResources("application.conf");
        String appName = appConfig.getString("application.name");

        // Get Spring context environment
        ConfigurableEnvironment environment = ((ConfigurableEnvironment) context.getEnvironment());

        // Define a File reference to resolve the application directory
        File appDirectory;
        if(SystemUtils.IS_OS_WINDOWS) {
            //log.info("Detected Windows operating system");
            appDirectory = new File("c:\\FHDA\\webapps\\" + appName);
        }
        else {
            appDirectory = new File("/var/fhda/" + appName);
        }
        //log.info("Using {} for application directory", appDirectory);

        // Define a File reference to resolve the application config file
        File appConfigFile;
        if(environment.containsProperty("extConfigFile")) {
            //log.info("Found 'extConfigFile' in web.xml context parameters");
            appConfigFile = new File(appDirectory, environment.getProperty("extConfigFile"));
        }
        else {
            appConfigFile = new File(appDirectory, appName + ".conf");
        }
        //log.info("Using {} for application configuration", appConfigFile);

        // Validate a config file exists
        if(appConfigFile.exists()) {
            // Load the config into a Spring property source
            TypesafePropertySource propertySource = new TypesafePropertySource(
                    "typesafe", ConfigFactory.parseFile(appConfigFile));

            //log.info("Loaded configuration successfully");

            // Attach to environment
            environment.getPropertySources().addLast(propertySource);
        }
        else {
            //log.info("Config file not found; not adding additional property source to Spring environment");
        }
    }

}
