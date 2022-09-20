package com.search.infrastructure.repository;

import com.search.domain.model.location.Locations;
import com.search.domain.repository.LocationRepository;
import com.search.domain.vo.Keyword;
import com.search.infrastructure.client.builder.ClientMonoBuilder;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class WebClientLocationRepository implements LocationRepository {

    private final List<ClientMonoBuilder> clientMonoBuilders;

    public WebClientLocationRepository(List<ClientMonoBuilder> clientMonoBuilders) {
        this.clientMonoBuilders = clientMonoBuilders;
    }

    @Override
    public Locations findBy(Keyword keyword) {


        return null;
    }
}
