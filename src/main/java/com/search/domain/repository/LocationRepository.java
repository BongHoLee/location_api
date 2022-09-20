package com.search.domain.repository;

import com.search.domain.model.location.Keyword;
import com.search.domain.model.location.Locations;

public interface LocationRepository {
    Locations findBy(Keyword keyword);
}
