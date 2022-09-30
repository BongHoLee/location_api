package com.search.infrastructure.repository;


import static org.assertj.core.api.Assertions.assertThat;

import com.search.domain.model.location.Locations;
import com.search.domain.vo.Search;
import com.search.infrastructure.client.builder.ClientMonoBuilder;
import com.search.infrastructure.client.builder.kakao.KakaoApiInfo;
import com.search.infrastructure.client.builder.kakao.KakaoClientMonoBuilder;
import com.search.infrastructure.client.builder.naver.NaverApiInfo;
import com.search.infrastructure.client.builder.naver.NaverClientMonoBuilder;
import com.search.infrastructure.repository.location.ClientLocationRepository;
import com.search.infrastructure.repository.location.LocationWebClients;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClientLocationRepositoryTest {

    LocationWebClients locationWebClients = new LocationWebClients(Arrays.asList(
            new KakaoClientMonoBuilder(kakaoApiInfo()),
       new NaverClientMonoBuilder(naverApiInfo())
    ));

    @Test
    @DisplayName("Kakao, Naver API 병렬 호출 테스트")
    void client_별_요청_처리_결과_반환_테스트() {

        ClientLocationRepository repository = new ClientLocationRepository(locationWebClients);
        Locations resultLocations = repository.findBy(new Search("곱창"));

        assertThat(resultLocations.getLocations()).hasSize(10);
    }

    private KakaoApiInfo kakaoApiInfo() {
        return KakaoApiInfo.builder()
                .host("https://dapi.kakao.com")
                .path("/v2/local/search/keyword.json")
                .apiKey("50d28f6653163fb835fe5931f9cf3ed3")
                .size("5")
                .build();
    }

    private NaverApiInfo naverApiInfo() {
        return NaverApiInfo.builder()
                .host("https://openapi.naver.com")
                .path("/v1/search/local.json")
                .clientId("_8o4EDT1hTGUY4iPKU90")
                .clientSecret("W8zCY43K_R")
                .displayCount("5")
                .build();
    }
}