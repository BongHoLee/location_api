package com.search.domain.model.location;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Title {
    private final String title;
    public Title(String title) {
        this.title = title;
    }
}
