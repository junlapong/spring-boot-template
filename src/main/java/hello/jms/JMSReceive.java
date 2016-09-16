package hello.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSReceive {

    private static final Logger logger = LoggerFactory.getLogger(JMSReceive.class);

    @JmsListener(containerFactory = "myContainerFactory", destination = "myQueue")
    public void processMessage(String content) throws InterruptedException {
        Thread.sleep(5000);
        logger.info("JMS Content Received: {}", content);
    }

}
