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

import java.util.List;

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

        List<String> strList = cache.opsForList().range("testlist",0,-1);
        System.out.println(strList.toString());
        cache.opsForList().trim("testlist",strList.size(),-1);
    }
}
