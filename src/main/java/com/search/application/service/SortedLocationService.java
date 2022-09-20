package com.search.application.service;

import com.search.domain.model.location.Locations;
import com.search.domain.model.location.function.LocationComparator;
import com.search.domain.repository.LocationRepository;
import com.search.domain.service.LocationService;
import com.search.domain.vo.Keyword;
import org.springframework.stereotype.Service;

@Service
public class SortedLocationService implements LocationService {
    private final LocationRepository locationRepository;
    private final LocationComparator comparator;

    public SortedLocationService(LocationRepository locationRepository, LocationComparator comparator) {
        this.locationRepository = locationRepository;
        this.comparator = comparator;
    }

    @Override
    public Locations searchBy(Keyword keyword) {
        Locations locations = locationRepository.findBy(keyword);
        return locations.sort(comparator);
    }
}
