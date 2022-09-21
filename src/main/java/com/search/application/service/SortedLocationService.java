package com.search.application.service;

import com.search.domain.model.location.Locations;
import com.search.domain.model.location.function.LocationsPostProcessor;
import com.search.domain.repository.LocationRepository;
import com.search.domain.service.LocationService;
import com.search.domain.vo.Keyword;
import org.springframework.stereotype.Service;

@Service
public class SortedLocationService implements LocationService {
    private final LocationRepository locationRepository;
    private final LocationsPostProcessor postProcessor;


    public SortedLocationService(LocationRepository locationRepository, LocationsPostProcessor postProcessor) {
        this.locationRepository = locationRepository;
        this.postProcessor = postProcessor;
    }

    @Override
    public Locations searchBy(Keyword keyword) {
        Locations locations = locationRepository.findBy(keyword);
        return locations.postProcessBy(postProcessor);
    }
}
