package com.search.domain.service.location;

import com.search.application.dto.LocationDTO;
import com.search.domain.vo.Search;
import java.util.List;

public interface LocationSearchService {
    List<LocationDTO> searchBy(Search search);
}
