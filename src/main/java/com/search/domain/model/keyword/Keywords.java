package com.search.domain.model.keyword;

import com.search.domain.model.keyword.function.KeywordsPostProcessor;
import java.util.List;
import lombok.Getter;

/**
 *
 * @author o118014_D
 * @since 2022-09-21
 */

@Getter
public class Keywords {
    private final List<Keyword> keywords;

    public Keywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public Keywords postProcessBy(KeywordsPostProcessor postProcessor) {
        return postProcessor.postProcess(this);
    }

}
