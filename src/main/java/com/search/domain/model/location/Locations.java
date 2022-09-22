package com.search.domain.model.location;

import com.search.domain.error.BusinessException;
import com.search.domain.error.DomainErrorCode;
import com.search.domain.model.location.function.LocationsPostProcessor;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
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

    private void validation(List<Location> locations) {
        if (locations == null) {
            log.error("locations cannot be null");
            throw new BusinessException(DomainErrorCode.INVALID_LOCATION_ERROR);
        }
    }
}
