package com.search.infrastructure.client.builder;

import com.search.domain.model.location.Locations;
import com.search.domain.vo.Keyword;
import com.search.infrastructure.client.builder.kakao.KakaoApiInfo;
import com.search.infrastructure.client.builder.kakao.KakaoClientMonoBuilder;
import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

/**
 * Class desc.
 *
 * @author o118014_D
 * @since 2022-09-20
 */

class ClientMonoBuilderTest {
    String apiKey = "50d28f6653163fb835fe5931f9cf3ed3";
    String host = "https://dapi.kakao.com";
    String auth = "KakaoAK " + apiKey;
    String path = "/v2/local/search/keyword.json";

    @Test
    void kakaoTest() {
        KakaoApiInfo kakaoApiInfo = KakaoApiInfo.builder()
                .host(host)
                .path(path)
                .apiKey(apiKey)
                .authKey("Authorization")
                .build();
        ClientMonoBuilder clientMonoBuilder = new KakaoClientMonoBuilder(kakaoApiInfo);

        Mono<Locations> result = clientMonoBuilder.buildFor(new Keyword("곱창"));

        Locations block = result.block();
        Assertions.assertThat(block).isNotNull();
    }

}