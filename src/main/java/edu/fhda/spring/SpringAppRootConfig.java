package edu.fhda.spring;

import edu.fhda.spring.util.DoNotModify;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiTemplate;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Spring app configuration class. The context loader will process this class first before building out any of the
 * web app infrastructure. All business logic beans, app configuration, should be defined
 * here.
 *
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = {"edu.fhda.spr12551demo", "edu.fhda.spring"})
@DoNotModify
public class SpringAppRootConfig {

    /**
     * Creates a production datasource that refers to a shared Banner data source hosted by the
     * webapp container (i.e. Tomcat)
     * @return If lookup is successful, a javax.sql.DataSource object
     * @throws NamingException If lookup fails and shared data source cannot be found
     */
    @Bean(destroyMethod = "")
    //@Profile("tomcat")
    public DataSource dataSource() throws NamingException {
        return (DataSource) new JndiTemplate().lookup("java:comp/env/jdbc/banner");
    }

}
