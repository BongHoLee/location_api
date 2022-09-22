package com.search.application.service.keyword.function;

import static java.util.stream.Collectors.toList;

import com.search.domain.model.keyword.Keyword;
import com.search.domain.model.keyword.Keywords;
import com.search.domain.model.keyword.function.KeywordsPostProcessor;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class KeywordsRankProcessor implements KeywordsPostProcessor {
    private static final int LIMIT_COUNT = 10;
    @Override
    public Keywords postProcess(Keywords originKeywords) {

        List<Keyword> collect = originKeywords.getKeywords()
                .stream()
                .sorted((o1, o2) -> o2.getSearchCount().compareTo(o1.getSearchCount()))
                .limit(LIMIT_COUNT)
                .collect(toList());

        return new Keywords(collect);
    }
}
