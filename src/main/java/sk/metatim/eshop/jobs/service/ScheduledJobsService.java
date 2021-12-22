package sk.metatim.eshop.jobs.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@EnableAsync
@Service
public class ScheduledJobsService {

    @Value("jobs.delay")
    @Getter
    private long delay;


    public void executeScheduledJob() {
        System.out.println("execute scheduled job");
    }

//    @Async
//    @Scheduled(fixedRate = 1000)
//    public void scheduleFixedRateTaskAsync() throws InterruptedException {
//        System.out.println(
//                "Fixed rate task async - " + System.currentTimeMillis() / 1000);
//        Thread.sleep(2000);
//    }
//
//    @Scheduled(fixedDelay = 1000)
//    public void scheduleFixedDelayTask() {
//        System.out.println(
//                "Fixed delay task - " + System.currentTimeMillis() / 1000);
//    }

//    @Scheduled(fixedRate = 1000)
//    public void scheduleFixedRateTask() {
//        System.out.println(
//                "Fixed rate task - " + System.currentTimeMillis() / 1000);
//    }

//    @Scheduled(fixedDelay = 1000, initialDelay = 1000)
//    public void scheduleFixedRateWithInitialDelayTask() {
//
//        long now = System.currentTimeMillis() / 1000;
//        System.out.println(
//                "Fixed rate task with one second initial delay - " + now);
//    }
//
////    @Scheduled(cron = "0 15 10 15 * ?", zone = "Europe/Paris")
//    @Scheduled(cron = "0 15 10 15 * ?")
//    public void scheduleTaskUsingCronExpression() {
//
//        long now = System.currentTimeMillis() / 1000;
//        System.out.println(
//                "schedule tasks using cron jobs - " + now);
//    }
}
