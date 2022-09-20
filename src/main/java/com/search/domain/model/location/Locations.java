package com.search.domain.model.location;

import static java.util.stream.Collectors.toList;

import com.search.domain.model.location.function.LocationComparator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Locations {
    private final List<Location> locations;

    public Locations(List<Location> locations) {
        validation(locations);
        this.locations = locations;
    }

    public void add(Locations targetLocations) {
        locations.addAll(targetLocations.locations);
    }

    public Locations sort(LocationComparator comparator) {
        return new Locations(locations.stream().sorted(comparator.compare()).collect(toList()));
    }

    private void validation(List<Location> locations) {
        if (locations == null) {
            log.error("locations cannot be null");
            throw new IllegalArgumentException("locations cannot be null");
        }
    }
}
