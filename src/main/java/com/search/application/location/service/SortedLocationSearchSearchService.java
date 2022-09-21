package com.search.application.location.service;

import com.search.application.dto.LocationDto;
import com.search.domain.model.location.Locations;
import com.search.domain.model.location.function.LocationsPostProcessor;
import com.search.domain.repository.LocationRepository;
import com.search.domain.service.LocationSearchService;
import com.search.domain.vo.Search;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class SortedLocationSearchSearchService implements LocationSearchService {
    private final LocationRepository locationRepository;
    private final LocationsPostProcessor postProcessor;


    public SortedLocationSearchSearchService(LocationRepository locationRepository, LocationsPostProcessor postProcessor) {
        this.locationRepository = locationRepository;
        this.postProcessor = postProcessor;
    }

    @Override
    public List<LocationDto> searchBy(Search search) {
        Locations locations = locationRepository.findBy(search);

        return locations.postProcessBy(postProcessor).getLocations()
                .stream().map(LocationDto::from).collect(Collectors.toList());
    }
}
