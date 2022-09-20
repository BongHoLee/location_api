package com.search.infrastructure.client.builder.kakao;

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

/**
 * @author o118014_D
 * @since 2022-09-20
 */
@Getter @Setter
public class KakaoResponseBody {
    @JsonProperty("documents")
    private List<Document> documents;

    public Locations ofLocations() {
        return new Locations(documents.stream().map(Document::ofLocation).collect(Collectors.toList()));
    }

    @Getter @Setter
    public static class Document {
        @JsonProperty("address_name")
        private String addressName;
        @JsonProperty("place_name")
        private String placeName;
        @JsonProperty("road_address_name")
        private String roadAddressName;

        public Location ofLocation() {
            return new Location(
                    new Source("kakao"),
                    new Title(placeName.replaceAll("\\<[^>]*>","")),
                    new Address(addressName.replaceAll("\\<[^>]*>",""), roadAddressName.replaceAll("\\<[^>]*>",""))
            );
        }
    }

}
