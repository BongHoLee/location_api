package com.search.domain.model.keyword;

import com.search.domain.error.BusinessException;
import com.search.domain.error.DomainErrorCode;
import com.search.domain.model.keyword.function.KeywordsPostProcessor;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Getter
@Slf4j
public class Keywords {
    private final List<Keyword> keywords;

    public Keywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Keywords postProcessBy(KeywordsPostProcessor postProcessor) {
        return postProcessor.postProcess(this);
    }

    private void validation(List<Keyword> keywords) {
        if (keywords == null || keywords.isEmpty()) {
            log.error("keywords cannot be empty");
            throw new BusinessException(DomainErrorCode.INVALID_KEYWORDS_ERROR);
        }
    }
}
