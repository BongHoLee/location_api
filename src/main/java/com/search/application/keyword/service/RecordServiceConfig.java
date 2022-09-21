package com.search.application.keyword.service;

import com.search.domain.repository.KeywordRepository;
import com.search.domain.service.keyword.KeywordRecordService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RecordServiceConfig {

    @Value("${lock.key}")
    private String lockKey;

    private final KeywordRepository keywordRepository;

    private final RedissonClient redissonClient;

    public RecordServiceConfig(KeywordRepository keywordRepository, RedissonClient redissonClient) {
        this.keywordRepository = keywordRepository;
        this.redissonClient = redissonClient;
    }

    @Bean
    public KeywordRecordService keywordRecordService() {
        return new LockingKeywordRecordService(transactionalRecordService(), redissonClient, lockKey);
    }

    @Bean
    public TransactionalRecordService transactionalRecordService() {
        return new TransactionalRecordService(keywordRepository);
    }
}
