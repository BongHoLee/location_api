package com.search.infrastructure.client.builder;

import com.search.domain.model.location.Locations;
import com.search.domain.vo.Search;
import com.search.infrastructure.client.frame.ClientRequestFrame;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author o118014_D
 * @since 2022-09-20
 */

public abstract class ClientMonoBuilder {
    public Mono<Locations> buildFor(Search search) {
        ClientRequestFrame clientRequestFrame = frameOf(search);
        return buildMono(clientRequestFrame);

    }
    private Mono<Locations> buildMono(ClientRequestFrame request) {
        return  WebClient.builder()
                .baseUrl(request.getHost()).build().get()
                .uri(uriBuilder -> uriBuilder.path(request.getPath()).queryParams(request.getQueryParam()).build())
                .headers(header -> request.getHeaders().forEach(each -> header.add(each.getHeaderKey(), each.getHeaderValue())))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, res -> res.bodyToMono(String.class).map(IllegalStateException::new))
                .onStatus(HttpStatus::is5xxServerError, res -> res.bodyToMono(String.class).map(IllegalStateException::new))
                .bodyToMono(supportType())
                .map(this::convert);
    }

    protected abstract ClientRequestFrame frameOf(Search search);
    protected abstract Class<?> supportType();
    protected abstract Locations convert(Object from);

}