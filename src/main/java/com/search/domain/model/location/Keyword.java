package com.search.domain.model.location;

import lombok.Getter;

@Getter
public class Keyword {
    private final String keyword;

    public Keyword(String keyword) {
        this.keyword = keyword;
    }
}
