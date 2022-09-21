package com.search.domain.model.location;

import com.search.domain.model.location.function.LocationsPostProcessor;
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

    public Locations postProcessBy(LocationsPostProcessor postProcessor) {
        return postProcessor.postProcess(this);
    }

    public List<Location> getLocations() {
        return this.locations;
    }

    private void validation(List<Location> locations) {
        if (locations == null) {
            log.error("locations cannot be null");
            throw new IllegalArgumentException("locations cannot be null");
        }
    }
}
