package com.search.domain.vo;

import lombok.Getter;

@Getter
public class Keyword {
    private final String keyword;

    public Keyword(String keyword) {
        this.keyword = keyword;
    }
}
