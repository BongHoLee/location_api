package com.search.infrastructure.client.builder.naver;

import static java.util.stream.Collectors.toList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.search.infrastructure.entity.LocationEntities;
import com.search.infrastructure.entity.LocationEntity;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class NaverResponseBody {
    @JsonProperty("items")
    private List<Item> items;

    public LocationEntities ofLocations() {
        return new LocationEntities(items.stream().map(Item::ofLocationEntity).collect(toList()));
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

        public LocationEntity ofLocationEntity() {
            return LocationEntity.builder()
                    .source("naver")
                    .title(title.replaceAll("\\<[^>]*>","").replace(" ", ""))
                    .localAddress(address.replaceAll("\\<[^>]*>",""))
                    .roadAddress(roadAddress.replaceAll("\\<[^>]*>",""))
                    .build();
        }
    }

}
