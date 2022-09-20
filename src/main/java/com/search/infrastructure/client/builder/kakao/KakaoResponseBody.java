package com.search.infrastructure.client.builder.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.search.domain.model.location.Address;
import com.search.domain.model.location.Location;
import com.search.domain.model.location.Locations;
import com.search.domain.model.location.Title;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;

/**
 * @author o118014_D
 * @since 2022-09-20
 */

 /*
        {
            "documents": [
              {
                "address_name": "서울 마포구 망원동 482-3",
                "category_group_code": "FD6",
                "category_group_name": "음식점",
                "category_name": "음식점 \u003e 한식 \u003e 육류,고기 \u003e 곱창,막창",
                "distance": "",
                "id": "13292214",
                "phone": "",
                "place_name": "청어람 망원점",
                "place_url": "http://place.map.kakao.com/13292214",
                "road_address_name": "서울 마포구 망원로 97",
                "x": "126.907469581002",
                "y": "37.558105169041376"
              }
            ],
            "meta": {
              "is_end": true,
              "pageable_count": 1,
              "same_name": {
                "keyword": "청어람 망원점",
                "region": [],
                "selected_region": ""
              },
              "total_count": 1
            }
          }
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
                    new Title(placeName),
                    new Address(addressName, roadAddressName)
            );
        }
    }

}
