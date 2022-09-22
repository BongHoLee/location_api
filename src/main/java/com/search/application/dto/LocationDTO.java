package com.search.application.dto;

import com.search.domain.model.location.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationDTO {
    private String source;
    private String title;
    private String locationAddress;
    private String roadAddress;
    public LocationDTO() {}

    public LocationDTO(String source, String title, String locationAddress, String roadAddress) {
        this.source = source;
        this.title = title;
        this.locationAddress = locationAddress;
        this.roadAddress = roadAddress;
    }

    public static LocationDTO from(Location location) {
        return new LocationDTO(
                location.getSource().getSourceName(),
                location.getTitle().getTitle(),
                location.getAddress().getLocalAddress(),
                location.getAddress().getRoadAddress()
        );
    }
}
