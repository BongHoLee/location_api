package com.search.application.dto;

import com.search.domain.model.keyword.Keyword;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class KeywordDTO {
    private String keyword;
    private Long searchCount;

    public KeywordDTO(){}

    public KeywordDTO(String keyword, Long searchCount) {
        this.keyword = keyword;
        this.searchCount = searchCount;
    }

    public static KeywordDTO from(Keyword keyword) {
        return new KeywordDTO(keyword.getKeyword(), keyword.getSearchCount());
    }
}
