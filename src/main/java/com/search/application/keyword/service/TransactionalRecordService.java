package com.search.application.keyword.service;

import com.search.domain.repository.KeywordRepository;
import com.search.domain.vo.Search;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *  검색 기록 트랜잭션을 수행하는 기본 서비스
 */

@Transactional
public class TransactionalRecordService {
    private final KeywordRepository repository;

    public TransactionalRecordService(KeywordRepository repository) {
        this.repository = repository;
    }

    public void record(Search search) {
        repository.save(search);
    }
}
