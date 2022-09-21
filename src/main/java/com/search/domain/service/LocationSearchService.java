package com.search.domain.service;

import com.search.application.dto.LocationDto;
import com.search.domain.vo.Search;
import java.util.List;

public interface LocationSearchService {
    List<LocationDto> searchBy(Search search);
}
