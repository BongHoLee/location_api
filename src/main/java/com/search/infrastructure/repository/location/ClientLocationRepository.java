package com.search.infrastructure.repository.location;

import com.search.domain.model.location.Locations;
import com.search.domain.repository.LocationRepository;
import com.search.domain.vo.Search;
import org.springframework.stereotype.Component;

@Component
public class ClientLocationRepository implements LocationRepository {
    private final LocationWebClients locationWebClients;

    public ClientLocationRepository(LocationWebClients locationWebClients) {
        this.locationWebClients = locationWebClients;
    }

    @Override
    public Locations findBy(Search search) {
        return locationWebClients.requestAbout(search).convert();
    }
}
