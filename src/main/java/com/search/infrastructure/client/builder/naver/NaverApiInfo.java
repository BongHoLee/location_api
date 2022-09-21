package com.search.infrastructure.client.builder.naver;

import com.search.infrastructure.client.builder.kakao.KakaoApiInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author o118014_D
 * @since 2022-09-20
 */

@Component
@ConfigurationProperties(prefix = "api.naver")
@Getter @Setter
public class NaverApiInfo {
    private String host;
    private String path;
    private String clientId;
    private String clientSecret;
    private String displayCount;

    public NaverApiInfo() {}
    @Builder
    public NaverApiInfo(String host, String path, String clientId, String clientSecret, String displayCount) {
        this.host = host;
        this.path = path;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.displayCount = displayCount;
    }
}
