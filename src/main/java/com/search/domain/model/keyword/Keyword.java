package com.search.domain.model.keyword;

import com.search.domain.error.BusinessException;
import com.search.domain.error.DomainErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EqualsAndHashCode
public class Keyword {
    private final Long id;
    private final String keyword;
    private final Long searchCount;

    public Keyword(Long id, String keyword, Long searchCount) {
        validation(id, keyword, searchCount);
        this.id = id;
        this.searchCount = searchCount;
        this.keyword = keyword;
    }

    private void validation(Long id, String keyword, Long searchCount) {
        if (id == null || keyword == null || searchCount == null) {
            throw new BusinessException(DomainErrorCode.INVALID_KEYWORD_ERROR);
        }
    }
}
