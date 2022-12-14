package com.search.infrastructure.client.builder.naver;

import com.search.domain.vo.Search;
import com.search.infrastructure.client.builder.ClientMonoBuilder;
import com.search.infrastructure.client.builder.LocationResponseBody;
import com.search.infrastructure.client.frame.ClientRequestFrame;
import com.search.infrastructure.client.frame.ClientRequestFrame.ClientRequestHeader;
import com.search.infrastructure.client.frame.ClientRequestFrame.ClientRequestQueryParam;
import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class NaverClientMonoBuilder extends ClientMonoBuilder {
    private static final String CLIENT_ID_HEADER = "X-Naver-Client-Id";
    private static final String CLIENT_SECRET_HEADER = "X-Naver-Client-Secret";
    private static final String QUERY_KEY = "query";
    private static final String DISPLAY_KEY = "display";
    private final NaverApiInfo apiInfo;

    public NaverClientMonoBuilder(NaverApiInfo apiInfo) {
        this.apiInfo = apiInfo;
    }

    @Override
    protected ClientRequestFrame frameOf(Search search) {
        return ClientRequestFrame.builder()
                .host(apiInfo.getHost())
                .path(apiInfo.getPath())
                .headers(Arrays.asList(
                        new ClientRequestHeader(CLIENT_ID_HEADER, apiInfo.getClientId()),
                        new ClientRequestHeader(CLIENT_SECRET_HEADER, apiInfo.getClientSecret())
                ))
                .params(Arrays.asList(
                        new ClientRequestQueryParam(QUERY_KEY, search.getSearch()),
                        new ClientRequestQueryParam(DISPLAY_KEY, apiInfo.getDisplayCount())
                ))
                .build();
    }

    @Override
    protected Class<? extends LocationResponseBody> supportType() {
        return NaverResponseBody.class;
    }

}



