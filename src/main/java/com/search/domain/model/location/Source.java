package com.search.domain.model.location;

import com.search.domain.error.BusinessException;
import com.search.domain.error.DomainErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


@Getter
@EqualsAndHashCode
@Slf4j
public class Source {
    private final String sourceName;
    public Source(String sourceName) {
        validation(sourceName);
        this.sourceName = sourceName;
    }

    private void validation(String sourceName) {
        if (sourceName == null || sourceName.isEmpty()) {
            log.error("source cannot be empty");
            throw new BusinessException(DomainErrorCode.INVALID_SOURCE_ERROR);
        }
    }
}
