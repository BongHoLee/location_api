package com.search.application.keyword.service;

import com.search.domain.service.keyword.KeywordRecordService;
import com.search.domain.vo.Search;
import java.util.concurrent.TimeUnit;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 *
 * redisson을 활용한 분산 락 활용 객체.
 * 트랜잭션 적용을 위해 TransactionRecordService에 처리를 위임
 */
public class LockingKeywordRecordService implements KeywordRecordService {
    private static final int WAIT_TIME = 10;
    private static final int LEASE_TIME = 3;

    private final RedissonClient redissonClient;
    private final TransactionalRecordService recordService;
    private final String lockKey;

    public LockingKeywordRecordService(
            TransactionalRecordService recordService,
            RedissonClient redissonClient,
            String lockKey
    ) {
        this.redissonClient = redissonClient;
        this.recordService = recordService;
        this.lockKey = lockKey;
    }


    @Override
    public void record(Search search) {
        RLock lock = redissonClient.getLock(lockKey);
        System.out.println(Thread.currentThread().getName() + " in record");

        try {
            boolean available = lock.tryLock(WAIT_TIME, LEASE_TIME, TimeUnit.SECONDS);
            // WAITE_TIME 내 Lock 획득한 경우
            if (available) {
                recordService.record(search);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isLocked() && lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }

    }
}
