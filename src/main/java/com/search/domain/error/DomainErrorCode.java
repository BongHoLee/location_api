package com.search.domain.error;

import com.fasterxml.jackson.annotation.JsonFormat;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DomainErrorCode implements ErrorCode {

    // KEYWORD domain
    INVALID_KEYWORD_ERROR(8010, "K001", " INVALID KEYWORD ERROR"),
    CANNOT_SEARCH_NULL_ERROR(8011, "K002", " SEARCH KEYWORD CANNOT BE NULL"),
    INVALID_KEYWORDS_ERROR(8012,"K003" ," INVALID KEYWORDS ERROR" ),

    // LOCATION DOMAIN
    INVALID_ADDRESS_ERROR(9010, "L001", " INVALID ADDRESS ERROR"),
    INVALID_LOCATION_ERROR(9011, "L002", " INVALID LOCATION ERROR"),
    INVALID_TITLE_ERROR(9012, "L003", " INVALID TITLE ERROR"),
    INVALID_SOURCE_ERROR(9012, "L004", " INVALID SOURCE ERROR"),
    ;


    private final String code;
    private final String message;
    private int status;

    DomainErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }
}
