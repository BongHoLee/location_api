package com.search.domain.model.location;

import com.search.domain.error.BusinessException;
import com.search.domain.error.DomainErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EqualsAndHashCode
@Getter
public class Title {
    private final String title;
    public Title(String title) {
        validation(title);
        this.title = title;
    }

    private void validation(String title) {
        if (title == null) {
            log.error("title cannot be null");
            throw new BusinessException(DomainErrorCode.INVALID_TITLE_ERROR);
        }
    }
}
