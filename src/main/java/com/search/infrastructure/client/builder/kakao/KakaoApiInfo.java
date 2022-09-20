package com.search.infrastructure.client.builder.kakao;

import lombok.Builder;
import lombok.Getter;

/**
 *
 * @author o118014_D
 * @since 2022-09-20
 */

@Getter
public class KakaoApiInfo {
    private final String apiKey;
    private final String host;
    private final String path;
    private final String size;

    @Builder
    public KakaoApiInfo(String apiKey, String host, String path, String size) {
        this.apiKey = apiKey;
        this.host = host;
        this.path = path;
        this.size = size;
    }
}
