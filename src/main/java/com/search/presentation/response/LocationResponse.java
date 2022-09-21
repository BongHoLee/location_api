package com.search.presentation.response;

import com.search.application.dto.LocationDTO;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LocationResponse {
    private List<LocationDTO> locations;

    private LocationResponse(List<LocationDTO> locations) {
        this.locations = locations;
    }

    public static LocationResponse of(List<LocationDTO> locations) {
        return new LocationResponse(locations);
    }
}
