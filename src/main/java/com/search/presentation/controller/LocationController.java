package com.search.presentation.controller;

import com.search.application.dto.LocationDTO;
import com.search.domain.error.BusinessException;
import com.search.domain.service.location.LocationSearchService;
import com.search.domain.vo.Search;
import com.search.presentation.error.exception.PresentationErrorCode;
import com.search.presentation.response.LocationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @Operation(summary = "장소 조회", description = "주어진 키워드로 10개 장소를 검색합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 완료"),
            @ApiResponse(responseCode = "204", description = "검색된 결과가 존재하지 않습니다."),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST, 조회 실패"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR, 조회 실패")})
    @GetMapping("/locations")
    public LocationResponse locationSearch(@RequestParam @NotEmpty @NotBlank @NotNull String search) {
        List<LocationDTO> locationResult = locationSearchService.searchBy(new Search(search));
        if (locationResult.isEmpty()) {
            throw new BusinessException(PresentationErrorCode.NO_CONTENT);
        }
        return LocationResponse.of(locationResult);
    }
}
