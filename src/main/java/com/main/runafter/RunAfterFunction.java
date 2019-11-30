package com.main.runafter;

import com.main.thread.TaskExcutor;
import com.main.thread.TestThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
@Order(value=1)
public class RunAfterFunction implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(RunAfterFunction.class);
    @Autowired
    private ThreadPoolTaskExecutor getExecutor;
    @Autowired
    private TestThread thread;
    @Autowired
    private RedisTemplate<String,String> cache;
    @Override
    public void run(String... args) throws Exception {
       /* for (int i = 0; i < 10; i++) {
            log.info("线程{}调起",i);
            cache.opsForList().rightPush("testlist",i+"");
            getExecutor.execute(thread);
        }*/
    }
}
