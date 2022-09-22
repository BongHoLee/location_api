package com.search.domain.vo;

import com.search.domain.error.BusinessException;
import com.search.domain.error.DomainErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Search {
    private final String search;
    public Search(String searchKeyword) {
        validation(searchKeyword);
        this.search = searchKeyword;
    }

    private void validation(String searchKeyword) {
        if (searchKeyword == null || searchKeyword.isEmpty()) {
            throw new BusinessException(DomainErrorCode.CANNOT_SEARCH_NULL_ERROR);
        }
    }
}
