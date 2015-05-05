package edu.fhda.spr12551demo;

import edu.fhda.spring.ExternalConfigurationLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Adapter to provide additional configuration to the test Spring context
 *
 * @author mrapczynski, Foothill-De Anza College District, rapczynskimatthew@fhda.edu
 * @version 1.0
 */
public class TestContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ExternalConfigurationLoader.apply(applicationContext);
    }

}
