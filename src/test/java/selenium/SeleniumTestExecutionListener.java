package selenium;

import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;
import static selenium.support.CaseFormat.toLowerUnderscore;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(SeleniumTestExecutionListener.class);

    private WebDriver webDriver;

    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @SuppressWarnings("resource")
	@Override
    public void prepareTestInstance(TestContext testContext) throws Exception {

        if (webDriver != null) {
            return;
        }

        ApplicationContext context = testContext.getApplicationContext();
        if (context instanceof ConfigurableApplicationContext) {

            SeleniumTest annotation = findAnnotation(testContext.getTestClass(), SeleniumTest.class);
            webDriver = BeanUtils.instantiate(annotation.driver());

            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) context;
            ConfigurableListableBeanFactory bf = configurableApplicationContext.getBeanFactory();
            bf.registerResolvableDependency(WebDriver.class, webDriver);
        }
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        logger.info("testContext == {}", testContext);
        if (webDriver != null) {
            SeleniumTest annotation = findAnnotation(testContext.getTestClass(), SeleniumTest.class);
            webDriver.get(annotation.baseUrl());
        }
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
        logger.info("testContext == {}", testContext);
        if (webDriver != null) {
            logger.info("quit browser");
            webDriver.quit();
        }
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        logger.info("testContext == {}", testContext);
        if (testContext.getTestException() != null) {
            return;
        }

        File screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        String testName = toLowerUnderscore(testContext.getTestClass().getSimpleName());
        String methodName = toLowerUnderscore(testContext.getTestMethod().getName());

        Files.copy(screenshot.toPath(), Paths.get("screenshots", testName + "_" + methodName + "_" + screenshot.getName()));
    }
}
