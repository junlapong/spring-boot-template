package hello.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@EnableScheduling
@Component
public class Jobs {

    private static final Logger logger = LoggerFactory.getLogger(Jobs.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "*/30 * * * * *")
    public void reportCurrentTime() {
        logger.info("The time is {}", dateFormat.format(new Date()));
    }

}
