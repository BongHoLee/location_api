package com.search.infrastructure.entity;


import com.search.domain.model.location.Address;
import com.search.domain.model.location.Location;
import com.search.domain.model.location.Source;
import com.search.domain.model.location.Title;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocationEntity {
    private String source;
    private String title;
    private String roadAddress;
    private String localAddress;

    @Builder
    public LocationEntity(String source, String title, String roadAddress, String localAddress) {
        this.source = source;
        this.title = title;
        this.roadAddress = roadAddress;
        this.localAddress = localAddress;
    }

    public Location convert() {
        return new Location(
                new Source(source),
                new Title(title),
                new Address(localAddress, roadAddress)
        );
    }
}
