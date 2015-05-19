package edu.fhda.spr12551demo;

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

    /* Spring beans */
    @Autowired private Environment environment;

}
