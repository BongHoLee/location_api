package com.search.infrastructure.client.builder.kakao;

import com.search.domain.vo.Search;
import com.search.infrastructure.client.builder.ClientMonoBuilder;
import com.search.infrastructure.client.builder.LocationResponseBody;
import com.search.infrastructure.client.frame.ClientRequestFrame;
import com.search.infrastructure.client.frame.ClientRequestFrame.ClientRequestHeader;
import com.search.infrastructure.client.frame.ClientRequestFrame.ClientRequestQueryParam;
import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class KakaoClientMonoBuilder extends ClientMonoBuilder {
    private static final String AUTH_PREFIX = "KakaoAK ";
    private static final String AUTH_HEADER = "Authorization";
    private static final String QUERY_KEY = "query";
    private static final String SIZE_KEY = "size";
    private final KakaoApiInfo apiInfo;

    public KakaoClientMonoBuilder(KakaoApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }

    @Override
    protected ClientRequestFrame frameOf(Search search) {
        return ClientRequestFrame.builder()
                .host(apiInfo.getHost())
                .path(apiInfo.getPath())
                .headers(Arrays.asList(new ClientRequestHeader(AUTH_HEADER, AUTH_PREFIX + apiInfo.getApiKey())))
                .params(Arrays.asList(
                        new ClientRequestQueryParam(QUERY_KEY, search.getSearch()),
                        new ClientRequestQueryParam(SIZE_KEY, apiInfo.getSize())))
                .build();
    }

    @Override
    protected Class<? extends LocationResponseBody> supportType() {
        return KakaoResponseBody.class;
    }
}



