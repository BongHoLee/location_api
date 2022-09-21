package com.search.application.dto;

import com.search.domain.model.location.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author o118014_D
 * @since 2022-09-21
 */

@Getter
@Setter
@ToString
public class LocationDto {
    private String source;
    private String title;
    private String locationAddress;
    private String roadAddress;

    public LocationDto() {
    }

    public LocationDto(String source, String title, String locationAddress, String roadAddress) {
        this.source = source;
        this.title = title;
        this.locationAddress = locationAddress;
        this.roadAddress = roadAddress;
    }

    public static LocationDto from(Location location) {
        return new LocationDto(
                location.getSource().getSourceName(),
                location.getTitle().getTitle(),
                location.getAddress().getLocationAddress(),
                location.getAddress().getRoadAddress()
        );
    }
}
