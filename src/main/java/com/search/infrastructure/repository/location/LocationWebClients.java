package com.search.infrastructure.repository.location;

import static java.util.stream.Collectors.toList;

import com.search.domain.vo.Search;
import com.search.infrastructure.client.builder.ClientMonoBuilder;
import com.search.infrastructure.entity.LocationEntities;
import java.util.ArrayList;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


@Component
public class LocationWebClients {
    private final List<ClientMonoBuilder> clientMonoBuilders;

    public LocationWebClients(List<ClientMonoBuilder> clientMonoBuilders) {
        this.clientMonoBuilders = clientMonoBuilders;
    }

    // 결과 캐싱
    @Cacheable(value = "LocationEntities", key = "#search")
    public LocationEntities requestAbout(Search search) {

        // WebClient 병렬 호출
        LocationEntities locationEntities = new LocationEntities(new ArrayList<>());
        clientMonoBuilders.stream()
                .parallel()
                .map(eachBuilder -> eachBuilder.buildFor(search))
                .map(eachMono -> eachMono.share().block())
                .collect(toList())
                .forEach(locationEntities::add);

        return locationEntities;
    }
}
