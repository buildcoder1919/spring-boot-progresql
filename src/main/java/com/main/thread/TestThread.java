package com.main.thread;

import com.main.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class TestThread implements Runnable {

    private Logger log = LoggerFactory.getLogger(TestThread.class);
    @Autowired
    private RedisTemplate<String,String> cache;
    private int i;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            task();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void task() throws Exception {
        lock.lock();
        int threadNo = i;
        i++;
        lock.unlock();
        String time = DateUtil.formatter18.get().format(new Date());
        log.info("线程{}working,redis.testlist={}",threadNo,cache.opsForList().leftPop("testlist",3,TimeUnit.SECONDS));
    }
}
