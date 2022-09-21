package com.search.infrastructure.client.builder.kakao;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 *
 * @author o118014_D
 * @since 2022-09-20
 */


@Component
@ConfigurationProperties(prefix = "api.kakao")
@Getter @Setter
public class KakaoApiInfo {
    private String apiKey;
    private String host;
    private String path;
    private String size;

    public KakaoApiInfo(){}

    @Builder
    public KakaoApiInfo(String apiKey, String host, String path, String size) {
        this.apiKey = apiKey;
        this.host = host;
        this.path = path;
        this.size = size;
    }
}
