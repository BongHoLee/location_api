package com.search.domain.model.location;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Address {
    private final String locationAddress;
    private final String roadAddress;

    public Address(String locationAddress, String roadAddress) {
        this.locationAddress = locationAddress;
        this.roadAddress = roadAddress;
    }
}
