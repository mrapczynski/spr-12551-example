package edu.fhda.spring;

import edu.fhda.spring.util.DoNotModify;
import freemarker.cache.WebappTemplateLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.ServletContext;

/**
 * Spring MVC configuration class. Spring will load this class when the application boot up and configure the
 * necessary defaults to being hosting the app. Customize this class as desired to change any of the default
 * behaviors and services.
 *
 * @version 1.0
 */
@Configuration
@ComponentScan(basePackages = {"edu.fhda.spr12551demo", "edu.fhda.spring"})
@DoNotModify
@EnableWebMvc
public class SpringWebAppConfig extends WebMvcConfigurerAdapter {

    /* Spring beans */
    @Autowired private ServletContext context;

    @Bean
    public FreeMarkerConfigurer freemarkerConfig() {
        // Create Freemarker configuration
        freemarker.template.Configuration configuration
            = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_22);
        configuration.setTemplateLoader(new WebappTemplateLoader(context, "WEB-INF/templates"));

        // Create Spring Freemarker configuration factory bean
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setConfiguration(configuration);
        return configurer;
    }

    @Bean
    public FreeMarkerViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache(true);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("WEB-INF/assets/");
    }

}