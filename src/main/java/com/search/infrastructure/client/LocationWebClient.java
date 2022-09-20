package com.search.infrastructure.client;

import com.search.domain.vo.Keyword;
import com.search.domain.model.location.Location;
import reactor.core.publisher.Mono;

public interface LocationWebClient {
    Mono<Location> search(Keyword keyword);
}
