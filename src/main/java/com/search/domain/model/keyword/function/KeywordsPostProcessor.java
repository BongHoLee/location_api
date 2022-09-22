package com.search.domain.model.keyword.function;

import com.search.domain.model.keyword.Keywords;

/**
 * Locations에 대한 후처리 작업을 위한 타입
 */

public interface KeywordsPostProcessor {
    Keywords postProcess(final Keywords originKeywords);
}
