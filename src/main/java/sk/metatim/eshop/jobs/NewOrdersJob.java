package sk.metatim.eshop.jobs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import sk.metatim.eshop.jobs.service.NewOrdersService;

@Configuration
public class NewOrdersJob {

    private static final Logger logger = LogManager.getLogger(NewOrdersJob.class);

    @Autowired
    NewOrdersService newOrdersService;

    @Scheduled(cron = "*/3 * * * * *")
    public void pingMe(){
        logger.info("ping");
    }
}
