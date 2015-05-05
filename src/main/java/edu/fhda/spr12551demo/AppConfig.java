package edu.fhda.spr12551demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * TODO: Your application specific beans and other services should be defined here
 *
 * @version 1.0
 */
@Configuration
public class AppConfig {

    /* SLF4J Logger */
    private final static Logger log = LoggerFactory.getLogger(AppConfig.class);

    /* Spring beans */
    @Autowired private Environment environment;

}
