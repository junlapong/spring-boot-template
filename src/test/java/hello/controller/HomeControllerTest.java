package hello.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import hello.Application;
import selenium.SeleniumTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(value = "server.port=9000")
@SeleniumTest(driver = FirefoxDriver.class, baseUrl = "http://localhost:9000")
public class HomeControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(HomeControllerTest.class);

    @Autowired
    private WebDriver driver;

    private HomePage homePage;

    @Before
    public void setUp() throws Exception {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    @Ignore
    public void containsActuatorLinks() {
        logger.info("hasActuatorLink ?");
        homePage.assertThat()
                .hasActuatorLink("autoconfig", "beans", "configprops", "dump"
                      , "env", "health", "info", "metrics", "mappings", "trace")
                .hasNoActuatorLink("shutdown");
    }

    @Test
    @Ignore
    public void failingTest() {
        homePage.assertThat().hasNoActuatorLink("autoconfig");
    }
}
