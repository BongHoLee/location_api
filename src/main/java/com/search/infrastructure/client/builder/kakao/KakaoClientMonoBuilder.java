package com.search.infrastructure.client.builder.kakao;

import com.search.domain.model.location.Locations;
import com.search.domain.vo.Keyword;
import com.search.infrastructure.client.builder.ClientMonoBuilder;
import com.search.infrastructure.client.frame.ClientRequestFrame;
import com.search.infrastructure.client.frame.ClientRequestFrame.ClientRequestHeader;
import com.search.infrastructure.client.frame.ClientRequestFrame.ClientRequestQueryParam;
import java.util.Arrays;

public class KakaoClientMonoBuilder extends ClientMonoBuilder {
    private static final String AUTH_PREFIX = "KakaoAK ";
    private static final String QUERY_KEY = "query";
    private final KakaoApiInfo kakaoApiInfo;

    public KakaoClientMonoBuilder(KakaoApiInfo kakaoApiInfo) {
        this.kakaoApiInfo = kakaoApiInfo;
    }

    @Override
    protected ClientRequestFrame frameOf(Keyword keyword) {
        return ClientRequestFrame.builder()
                .host(kakaoApiInfo.getHost())
                .path(kakaoApiInfo.getPath())
                .headers(Arrays.asList(new ClientRequestHeader(kakaoApiInfo.getAuthKey(), AUTH_PREFIX + kakaoApiInfo.getApiKey())))
                .params(Arrays.asList(new ClientRequestQueryParam(QUERY_KEY, keyword.getKeyword())))
                .build();
    }

    @Override
    protected Class<?> supportType() {
        return KakaoResponseBody.class;
    }

    @Override
    protected Locations convert(Object from) {
        KakaoResponseBody origin = (KakaoResponseBody) from;
        return origin.ofLocations();
    }
}



