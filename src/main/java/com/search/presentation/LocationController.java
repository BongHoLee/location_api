package com.search.presentation;

import com.search.application.dto.LocationDto;
import com.search.domain.service.LocationSearchService;
import com.search.domain.vo.Search;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class desc.
 *
 * @author o118014_D
 * @since 2022-09-21
 */

@RestController
@RequestMapping("/v1/search")
public class LocationController {

    private final LocationSearchService locationSearchService;

    public LocationController(LocationSearchService locationSearchService) {
        this.locationSearchService = locationSearchService;
    }

    @GetMapping("/location")
    public List<LocationDto> locationSearch(@RequestParam String search) {
         return locationSearchService.searchBy(new Search(search));
    }
}
