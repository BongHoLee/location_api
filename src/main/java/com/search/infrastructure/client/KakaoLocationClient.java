package com.search.infrastructure.client;

import com.search.domain.model.location.Address;
import com.search.domain.model.location.Keyword;
import com.search.domain.model.location.Location;
import com.search.domain.model.location.Title;
import lombok.RequiredArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class KakaoLocationClient implements LocationWebClient {

    private final String apiKey;
    private final String host;
    private final String auth;
    private final String path;

    @Override
    public Mono<Location> search(Keyword keyword) {
        return WebClient.builder()
                .baseUrl(host).build().get()
                .uri(uriBuilder -> uriBuilder.path(path).queryParam("query", keyword.getKeyword()).build())
                .headers(httpHeaders -> httpHeaders.set("Authorization", auth))
                .retrieve()
                .bodyToMono(Location.class)


    }
}
