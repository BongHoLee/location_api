package com.search.domain.service;

import com.search.domain.model.location.Locations;
import com.search.domain.vo.Keyword;

public interface LocationService {
    Locations searchBy(Keyword keyword);
}
