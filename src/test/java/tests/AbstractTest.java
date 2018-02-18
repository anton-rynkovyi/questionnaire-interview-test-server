package tests;

import com.qit.server.ApplicationInitializer;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Arizel on 30.12.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationInitializer.class})
@ComponentScan("")
public class AbstractTest {

    private static final Logger LOG = Logger.getLogger(AbstractTest.class);
    protected static final String SEPARATOR = "--------------------------------------------------";

    @Test
    public void printHelloWorld() {
        LOG.info("Hello WORLD!");
    }

}
