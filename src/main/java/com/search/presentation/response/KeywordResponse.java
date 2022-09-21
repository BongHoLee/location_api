package com.search.presentation.response;

import com.search.application.dto.KeywordDTO;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class KeywordResponse {
    private List<KeywordDTO> keywords;

    private KeywordResponse(List<KeywordDTO> keywords) {
        this.keywords = keywords;
    }

    public static KeywordResponse of(List<KeywordDTO> keywords) {
        return new KeywordResponse(keywords);
    }
}
