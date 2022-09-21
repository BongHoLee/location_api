package com.search.application.keyword.service;

import static java.util.stream.Collectors.toList;

import com.search.application.dto.KeywordDTO;
import com.search.domain.model.keyword.Keyword;
import com.search.domain.model.keyword.Keywords;
import com.search.domain.model.keyword.function.KeywordsPostProcessor;
import com.search.domain.repository.KeywordRepository;
import com.search.domain.service.keyword.KeywordListUpService;
import java.util.List;
import java.util.stream.Collectors;
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
    public List<KeywordDTO> listUpKeywords() {
        Keywords keywords = keywordRepository.findAll();

        return keywords.postProcessBy(keywordsPostProcessor).getKeywords()
                .stream().map(KeywordDTO::from).collect(toList());
    }
}
