package com.search.domain.model.location.function;

import com.search.domain.model.location.Locations;

/**
 * Locations에 대한 후처리 작업을 위한 타입
 */

public interface LocationsPostProcessor {
    Locations postProcess(final Locations originLocations);
}
