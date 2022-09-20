package com.search.domain.model.location;

/**
 * {
 * 	"lastBuildDate":"Mon, 19 Sep 2022 22:14:06 +0900",
 * 	"total":1,
 * 	"start":1,
 * 	"display":1,
 * 	"items":[
 *                {
 * 			"title":"청어람 망원점",
 * 			"link":"",
 * 			"category":"한식>곱창,막창,양",
 * 			"description":"",
 * 			"telephone":"",
 * 			"address":"서울특별시 마포구 망원동 482-3",
 * 			"roadAddress":"서울특별시 마포구 망원로 97",
 * 			"mapx":"303671",
 * 			"mapy":"551215"
 *        }
 * 	]
 * }
 *
 *{
 *   "documents": [
 *     {
 *       "address_name": "서울 마포구 망원동 482-3",
 *       "category_group_code": "FD6",
 *       "category_group_name": "음식점",
 *       "category_name": "음식점 \u003e 한식 \u003e 육류,고기 \u003e 곱창,막창",
 *       "distance": "",
 *       "id": "13292214",
 *       "phone": "",
 *       "place_name": "청어람 망원점",
 *       "place_url": "http://place.map.kakao.com/13292214",
 *       "road_address_name": "서울 마포구 망원로 97",
 *       "x": "126.907469581002",
 *       "y": "37.558105169041376"
 *     }
 *   ],
 *   "meta": {
 *     "is_end": true,
 *     "pageable_count": 1,
 *     "same_name": {
 *       "keyword": "청어람 망원점",
 *       "region": [],
 *       "selected_region": ""
 *     },
 *     "total_count": 1
 *   }
 * }
 */


public class Location {
    private final Title title;
    private final Address address;

    public Location(Title title, Address address) {
        this.title = title;
        this.address = address;
    }

    public Title getTitle() {
        return title;
    }

    public Address getAddress() {
        return address;
    }
}
