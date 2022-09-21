package com.search.infrastructure.repository.location;

import static java.util.stream.Collectors.toList;

import com.search.domain.model.location.Locations;
import com.search.domain.repository.LocationRepository;
import com.search.domain.vo.Search;
import com.search.infrastructure.client.builder.ClientMonoBuilder;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class WebClientLocationRepository implements LocationRepository {
    private final List<ClientMonoBuilder> clientMonoBuilders;

    public WebClientLocationRepository(List<ClientMonoBuilder> clientMonoBuilders) {
        this.clientMonoBuilders = clientMonoBuilders;
    }

    // parallel call and merge
    @Override
    public Locations findBy(Search search) {
        Locations locations = new Locations(new ArrayList<>());

        clientMonoBuilders.stream()
                .map(eachBuilder -> eachBuilder.buildFor(search))
                .map(eachMono -> eachMono.share().block())
                .collect(toList())
                .forEach(locations::add);

        return locations;
    }
}
