package com.search.domain.vo;

import lombok.Getter;

@Getter
public class Search {
    private final String search;
    public Search(String searchKeyword) {
        validation(searchKeyword);
        this.search = searchKeyword;
    }

    private void validation(String searchKeyword) {
        if (searchKeyword == null || searchKeyword.isEmpty()) {
            throw new IllegalArgumentException("search keyword cannot be empty");
        }
    }
}
