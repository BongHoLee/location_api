package com.search.application.service.location;

import com.search.application.dto.LocationDTO;
import com.search.domain.model.location.Locations;
import com.search.domain.model.location.function.LocationsPostProcessor;
import com.search.domain.repository.LocationRepository;
import com.search.domain.service.keyword.KeywordRecordService;
import com.search.domain.service.location.LocationSearchService;
import com.search.domain.vo.Search;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SortedLocationSearchService implements LocationSearchService {
    private final LocationRepository locationRepository;
    private final LocationsPostProcessor postProcessor;
    private final KeywordRecordService keywordRecordService;

    public SortedLocationSearchService(
            LocationRepository locationRepository,
            LocationsPostProcessor postProcessor,
            KeywordRecordService keywordRecordService) {
        this.locationRepository = locationRepository;
        this.postProcessor = postProcessor;
        this.keywordRecordService = keywordRecordService;
    }

    /**
     *
     * 검색 기록을 위한 서비스 호출 -
     */
    @Override
    public List<LocationDTO> searchBy(Search search) {
        keywordRecordService.record(search);
        Locations locations = locationRepository.findBy(search);

        return locations.postProcessBy(postProcessor).getLocations()
                .stream().map(LocationDTO::from).collect(Collectors.toList());
    }
}
