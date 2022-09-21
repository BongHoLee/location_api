package com.search.domain.repository;

import com.search.domain.vo.Search;
import com.search.domain.model.location.Locations;

public interface LocationRepository {
    Locations findBy(Search search);
}
