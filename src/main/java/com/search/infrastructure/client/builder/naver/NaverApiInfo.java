package com.search.infrastructure.client.builder.naver;

import com.search.infrastructure.client.frame.ClientRequestFrame;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author o118014_D
 * @since 2022-09-20
 */

@Getter @Setter
public class NaverApiInfo {
    private String host;
    private String path;
    private String clientId;
    private String clientSecret;
    private String displayCount;

    @Builder
    public NaverApiInfo(String host, String path, String clientId, String clientSecret, String displayCount) {
        this.host = host;
        this.path = path;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.displayCount = displayCount;
    }
}
