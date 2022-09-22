package com.search.domain.repository;

import com.search.domain.model.keyword.Keywords;
import com.search.domain.vo.Search;


public interface KeywordRepository {
    void save(Search search);
    Keywords findAll();
}
