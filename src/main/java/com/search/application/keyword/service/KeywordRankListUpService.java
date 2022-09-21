package com.search.application.keyword.service;

import com.search.domain.model.keyword.Keywords;
import com.search.domain.model.keyword.function.KeywordsPostProcessor;
import com.search.domain.repository.KeywordRepository;
import com.search.domain.service.keyword.KeywordListUpService;
import org.springframework.stereotype.Service;

@Service
public class KeywordRankListUpService implements KeywordListUpService {

    private final KeywordRepository keywordRepository;
    private final KeywordsPostProcessor keywordsPostProcessor;

    public KeywordRankListUpService(KeywordRepository keywordRepository, KeywordsPostProcessor keywordsPostProcessor) {
        this.keywordRepository = keywordRepository;
        this.keywordsPostProcessor = keywordsPostProcessor;
    }

    @Override
    public Keywords listUpKeywords() {
        Keywords keywords = keywordRepository.findAll();
        return keywords.postProcessBy(keywordsPostProcessor);
    }
}
