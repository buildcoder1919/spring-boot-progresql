package com.main.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class TaskExcutor {

    private Logger log = LoggerFactory.getLogger(TaskExcutor.class);
    @Autowired
    private ThreadPoolTaskExecutor getExecutor;
    @Autowired
    private TestThread thread;


//    @Scheduled(fixedDelay = 2000)
    public void task() {
        for (int i = 0; i < 10; i++) {
            log.info("线程{}调起",i);
            getExecutor.execute(thread);
        }
    }
}
