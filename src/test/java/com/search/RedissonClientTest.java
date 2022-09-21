package com.search;

import com.search.domain.model.keyword.Keywords;
import com.search.domain.service.keyword.KeywordListUpService;
import com.search.domain.service.keyword.KeywordRecordService;
import com.search.domain.vo.Search;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedissonClientTest {

    @Autowired
    RedissonClient client;

    @Autowired
    KeywordRecordService keywordRecordService;

    @Autowired
    KeywordListUpService listUpService;

    @Test
    void tttest() {
        Keywords keywords = listUpService.listUpKeywords();
        System.out.println(keywords);
    }

    @Test
    void ttest() throws InterruptedException {
        int threadCount = 100;
        ExecutorService es = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            String suffix = Integer.toString((i+1)%6);
            es.submit(() -> {
               try {
                   String keyword = "곱창- " + suffix;
                   Search search = new Search(keyword);
                   System.out.println(Thread.currentThread().getName() + " start with " + search.getSearch());
                   keywordRecordService.record(search);
               } finally {
                   latch.countDown();
               }
            });
        }

        latch.await();
    }

    @Test
    void contextLoads() throws InterruptedException {
        String key = "bh_key";
        int threadCount = 20;
        ExecutorService es = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            System.out.println("count : " + i);
            es.submit(() -> {
                try {
                    acquire(key);
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
    }

    private void acquire(String key) {
        RLock lock = client.getLock(key);
        try {
            boolean available = lock.tryLock(10, 1, TimeUnit.SECONDS);

            if (available) {
                System.out.println(Thread.currentThread().getName() + " LOCK ACQURIED!");

                Thread.sleep(500);
            } else {
                System.out.println(Thread.currentThread().getName() + " LOCK ACQUIRE FAIL!");
                return;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock != null && lock.isLocked()) {
                System.out.println(Thread.currentThread().getName() + " UNLOCK!");
                lock.unlock();
            }
        }
    }

}
