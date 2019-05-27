package com.wyj.scheduledtask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Scheduled(fixedRate = 5000) ：上一次开始执行之后5秒再执行
 * @Scheduled(fixedDelay = 5000) ：上一次执行完之后5秒再执行
 * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
 * @Scheduled(cron = "* /5 * * * * ?") ：通过cron表达式定义规则
 */
@Component
public class DemoScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(DemoScheduledTasks.class);
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    @Scheduled(cron = "*/5 * * * * ?")
    public void reportCurrentTime() {
        log.info("当前时间：", simpleDateFormat.format(new Date()));
    }

}
