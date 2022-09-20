package com.search.domain.model.location;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Title {
    private final String title;

    public Title(String title) {
        this.title = title;
    }
}
