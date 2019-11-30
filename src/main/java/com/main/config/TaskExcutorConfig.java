package com.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExcutorConfig {

    public ThreadPoolTaskExecutor getExecutor() {
        ThreadPoolTaskExecutor taskExcutor=new ThreadPoolTaskExecutor();
        taskExcutor.setCorePoolSize(5);
        taskExcutor.setMaxPoolSize(10);
        taskExcutor.setQueueCapacity(25);
        taskExcutor.setThreadNamePrefix("test-task-");
        taskExcutor.initialize();
        return taskExcutor;
    }
}
