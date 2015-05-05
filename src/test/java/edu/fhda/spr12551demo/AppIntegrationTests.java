package edu.fhda.spr12551demo;

import edu.fhda.spring.SpringAppRootConfig;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * TODO: Describe the test cases executed by this JUnit suite.
 *
 * @version 1.0
 */
@ContextConfiguration(
    classes = {SpringAppRootConfig.class, TestConfiguration.class},
    initializers = {TestContextInitializer.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AppIntegrationTests {

    /* Spring beans */
    @Autowired ApplicationContext applicationContext;

    @Test
    public void T001_didContextLoad() {
        assert applicationContext != null;
    }

}
