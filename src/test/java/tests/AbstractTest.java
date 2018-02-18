package tests;

import com.qit.server.config.common.DatabaseConfig;
import com.qit.server.config.common.WebConfig;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class, WebConfig.class})
@WebAppConfiguration
public class AbstractTest {

    private static final Logger LOG = Logger.getLogger(AbstractTest.class);
    protected static final String SEPARATOR = "--------------------------------------------------";

    @Test
    public void printHelloWorld() {
        LOG.info("Hello WORLD!");
    }

}
