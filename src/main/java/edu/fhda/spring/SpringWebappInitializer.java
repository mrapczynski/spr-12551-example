package edu.fhda.spring;

import edu.fhda.spring.util.DoNotModify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Servlet container initialization class. The J2EE web container will load this class automatically and boot
 * up the Spring context for your application. <strong>Do not modify.</strong>
 *
 * @version 1.0
 */
@DoNotModify
public class SpringWebappInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /* SLF4J Logger */
    private final static Logger log = LoggerFactory.getLogger(SpringWebappInitializer.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SpringAppRootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { SpringWebAppConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected WebApplicationContext createRootApplicationContext() {
        // Create the application context using the Spring logic
        WebApplicationContext context = super.createRootApplicationContext();

        // Apply external application config
        ExternalConfigurationLoader.apply(context);

        // Return the customized application context
        return context;
    }

}
