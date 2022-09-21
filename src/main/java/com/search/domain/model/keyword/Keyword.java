package com.search.domain.model.keyword;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 *
 * @author o118014_D
 * @since 2022-09-21
 */

@Getter
@EqualsAndHashCode
public class Keyword {
    private final Long id;
    private final String keyword;
    private final Long searchCount;

    public Keyword(Long id, String keyword, Long searchCount) {
        this.id = id;
        this.searchCount = searchCount;
        this.keyword = keyword;
    }
}
