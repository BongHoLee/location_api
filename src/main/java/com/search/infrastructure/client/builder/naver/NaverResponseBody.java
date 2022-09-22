package com.search.infrastructure.client.builder.naver;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.search.domain.model.location.Address;
import com.search.domain.model.location.Location;
import com.search.domain.model.location.Locations;
import com.search.domain.model.location.Source;
import com.search.domain.model.location.Title;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NaverResponseBody {
    @JsonProperty("items")
    private List<Item> items;

    public Locations ofLocations() {
        return new Locations(items.stream().map(Item::ofLocation).collect(Collectors.toList()));
    }

    @Getter
    @Setter
    public static class Item {
        @JsonProperty("address")
        private String address;
        @JsonProperty("title")
        private String title;
        @JsonProperty("roadAddress")
        private String roadAddress;

        public Location ofLocation() {
            return new Location(
                    new Source("naver"),
                    new Title(title.replaceAll("\\<[^>]*>","").replace(" ", "")),
                    new Address(address.replaceAll("\\<[^>]*>",""), roadAddress.replaceAll("\\<[^>]*>",""))
            );
        }
    }

}
