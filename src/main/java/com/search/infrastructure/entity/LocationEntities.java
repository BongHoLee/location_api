package com.search.infrastructure.entity;


import static java.util.stream.Collectors.toList;

import com.search.domain.model.location.Locations;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocationEntities {
    private List<LocationEntity> locationEntities;

    public LocationEntities(List<LocationEntity> locationEntities) {
        this.locationEntities = locationEntities;
    }

    public void add(LocationEntities targetEntities) {
        locationEntities.addAll(targetEntities.getLocationEntities());
    }

    public Locations convert() {
        return new Locations(locationEntities.stream().map(LocationEntity::convert).collect(toList()));
    }
}
