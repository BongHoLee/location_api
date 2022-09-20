package com.search.infrastructure.client.builder.naver;

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
         	"lastBuildDate":"Mon, 19 Sep 2022 22:14:06 +0900",
         	"total":1,
         	"start":1,
         	"display":1,
         	"items":[
                        {
         			"title":"청어람 망원점",
         			"link":"",
         			"category":"한식>곱창,막창,양",
         			"description":"",
         			"telephone":"",
         			"address":"서울특별시 마포구 망원동 482-3",
         			"roadAddress":"서울특별시 마포구 망원로 97",
         			"mapx":"303671",
         			"mapy":"551215"
                }
         	]
         }

 */
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
                    new Title(title),
                    new Address(address, roadAddress)
            );
        }
    }

}
