package com.search.application.location.service;

import com.search.domain.repository.KeywordRepository;
import com.search.domain.service.keyword.KeywordRecordService;
import com.search.domain.vo.Search;
import org.springframework.stereotype.Service;

/**
 *
 * @author o118014_D
 * @since 2022-09-21
 */

@Service
public class KeywordRecordingRecordService implements KeywordRecordService {
    private final KeywordRepository keywordRepository;

    public KeywordRecordingRecordService(KeywordRepository keywordRepository) {
        this.keywordRepository = keywordRepository;
    }

    @Override
    public void record(Search search) {
        keywordRepository.save(search);
    }
}
