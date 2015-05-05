package edu.fhda.spring;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import edu.fhda.spring.util.DoNotModify;
import org.springframework.core.env.PropertySource;

/**
 * Wraps a Typesafe Config object in a neutral Spring PropertySource so that customized application properties
 * can be accessed from an external file.
 *
 * @author mrapczynski, Foothill-De Anza College District, rapczynskimatthew@fhda.edu
 * @version 1.0
 */
@DoNotModify
public class TypesafePropertySource extends PropertySource<Config> {

    public TypesafePropertySource(String name, Config source) {
        super(name, source);
    }

    @Override
    public Object getProperty(String name) {
        try {
            // Get the property value from the Typesafe object
            return source.getAnyRef(name);
        }
        catch(ConfigException.Missing valueNotFoundException) {
            // If property is not found, return null (expected per Spring Javadocs)
            return null;
        }
    }

}
