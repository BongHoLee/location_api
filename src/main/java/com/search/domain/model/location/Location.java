package com.search.domain.model.location;

import com.search.domain.error.BusinessException;
import com.search.domain.error.DomainErrorCode;
import java.util.Objects;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
public class Location {
    private final Source source;
    private final Title title;
    private final Address address;

    public Location(Source source, Title title, Address address) {
        validation(source, title, address);
        this.source = source;
        this.title = title;
        this.address = address;
    }

    private void validation(Source source, Title title, Address address) {
        if (source == null || title == null || address == null) {
            log.error("Location arguments cannot be null");
            throw new BusinessException(DomainErrorCode.INVALID_LOCATION_ERROR);
        }
    }

    public Title getTitle() {
        return title;
    }

    public Address getAddress() {
        return address;
    }

    public Source getSource() {
        return source;
    }


    /**
     * Title을 기준으로 동등성을 비교
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location location = (Location) o;
        return getTitle().equals(location.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}
