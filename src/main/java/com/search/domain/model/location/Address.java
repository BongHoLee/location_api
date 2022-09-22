package com.search.domain.model.location;

import com.search.domain.error.BusinessException;
import com.search.domain.error.DomainErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
@Getter
public class Address {
    private final String locationAddress;
    private final String roadAddress;

    public Address(String locationAddress, String roadAddress) {
        validation(locationAddress, roadAddress);
        this.locationAddress = locationAddress;
        this.roadAddress = roadAddress;
    }

    private void validation(String locationAddress, String roadAddress) {
        if (locationAddress == null || roadAddress == null) {
            log.error("Address cannot be null");
            throw new BusinessException(DomainErrorCode.INVALID_ADDRESS_ERROR);
        }
    }
}
