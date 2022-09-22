package com.search.application.keyword.function;

import static org.assertj.core.api.Assertions.assertThat;

import com.search.application.service.keyword.function.KeywordsRankProcessor;
import com.search.domain.model.keyword.Keyword;
import com.search.domain.model.keyword.Keywords;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KeywordsRankProcessorTest {

    @Test
    @DisplayName("검색어 순위 순서 정렬 테스트")
    void keywordsRankProcessorTest() {

        KeywordsRankProcessor rankProcessor = new KeywordsRankProcessor();
        Keywords keywords = keywords();
        Keywords result = keywords.postProcessBy(rankProcessor);

        assertThat(result.getKeywords())
                .containsExactly(
                        new Keyword(4L, "E", 8L),
                        new Keyword(3L, "D", 4L),
                        new Keyword(1L, "B", 3L),
                        new Keyword(2L, "C", 2L),
                        new Keyword(0L, "A", 1L)
                );
    }

    private Keywords keywords() {
        return new Keywords(new ArrayList<>(
                Arrays.asList(
                        new Keyword(0L, "A", 1L),
                        new Keyword(1L, "B", 3L),
                        new Keyword(2L, "C", 2L),
                        new Keyword(3L, "D", 4L),
                        new Keyword(4L, "E", 8L)
                )
        ));
    }

}