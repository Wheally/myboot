package com.hzm.boot.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @desc SpringBoot集成Quartz
 * @author xiaoqian
 *
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 固定5秒执行一次
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }

    /**
     * cron表达式
     */
    @Scheduled(cron = "0/20 * * * * ?")
    public void testTaskCron(){
        log.info("task-cron time is now {}", dateFormat.format(new Date()));
    }

}