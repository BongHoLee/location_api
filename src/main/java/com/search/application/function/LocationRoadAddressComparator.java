package com.search.application.function;

import com.search.domain.model.location.Location;
import com.search.domain.model.location.function.LocationComparator;
import java.util.Comparator;
import org.springframework.stereotype.Component;

/**
 * 카카오, 네이버 모두 존재하면 상위로
 *
 */
@Component
public class LocationRoadAddressComparator implements LocationComparator {
    private final Priority priority;

    public LocationRoadAddressComparator(Priority priority) {
        this.priority = priority;
    }

    @Override
    public Comparator<Location> compare() {
        return null;
    }


}
