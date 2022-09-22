package com.search.presentation.controller;

import com.search.application.dto.LocationDTO;
import com.search.domain.service.location.LocationSearchService;
import com.search.domain.vo.Search;
import com.search.presentation.response.LocationResponse;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/search")
public class LocationController {
    private final LocationSearchService locationSearchService;

    public LocationController(LocationSearchService locationSearchService) {
        this.locationSearchService = locationSearchService;
    }

    @GetMapping("/location")
    public LocationResponse locationSearch(@RequestParam String search) {
         return LocationResponse.of(locationSearchService.searchBy(new Search(search)));
    }
}
