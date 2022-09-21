package com.search.domain.repository;

import com.search.domain.model.keyword.Keywords;
import com.search.domain.vo.Search;

/**
 * @author o118014_D
 * @since 2022-09-21
 */

public interface KeywordRepository {
    void save(Search search);
    Keywords findAll();
}
