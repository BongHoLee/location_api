package com.search.domain.model.location;

import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EqualsAndHashCode
public class Source {
    private final String sourceName;

    public Source(String sourceName) {
        this.sourceName = sourceName;
    }
}
