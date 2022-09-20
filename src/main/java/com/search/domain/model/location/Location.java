package com.search.domain.model.location;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Location {
    private final Source source;
    private final Title title;
    private final Address address;

    public Location(Source source,Title title, Address address) {
        this.source = source;
        this.title = title;
        this.address = address;
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
}
