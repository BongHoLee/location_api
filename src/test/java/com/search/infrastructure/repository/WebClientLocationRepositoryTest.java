package com.search.infrastructure.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

class WebClientLocationRepositoryTest {

    @Test
    @DisplayName("카카오 API 호출 테스트")
    void 카카오_API_호출_테스트() {
        String apiKey = "50d28f6653163fb835fe5931f9cf3ed3";
        String host  = "https://dapi.kakao.com";
        String auth = "KakaoAK " + apiKey;
        String method = "/v2/local/search/keyword.json";

        Mono<String> searchResultMono1 = kakaoWebClientRequest(host, auth, method, "곱창");
        Mono<String> searchResultMono2 = kakaoWebClientRequest(host, auth, method, "갈비");
        List<Mono<?>> resultList = Arrays.asList(searchResultMono1, searchResultMono2);

        assertThat(Mono.zip(resultList, result -> result).block())
                .hasSize(resultList.size())
                .isNotNull();
    }

    private Mono<String> kakaoWebClientRequest(String host, String auth, String method, String query) {
        return WebClient.builder()
                .baseUrl(host).build().get()
                .uri(uriBuilder -> uriBuilder.path(method).queryParam("query", query).build())
                .header("Authorization", auth)
                .exchangeToMono(response -> response.bodyToMono(String.class));
    }
}
