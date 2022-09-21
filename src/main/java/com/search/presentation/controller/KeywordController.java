package com.search.presentation.controller;

import com.search.application.dto.KeywordDTO;
import com.search.application.dto.LocationDTO;
import com.search.domain.model.keyword.Keywords;
import com.search.domain.service.keyword.KeywordListUpService;
import com.search.domain.vo.Search;
import com.search.presentation.response.KeywordResponse;
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
@RequestMapping("/v1/keyword")
public class KeywordController {

    private final KeywordListUpService keywordListUpService;

    public KeywordController(KeywordListUpService keywordListUpService) {
        this.keywordListUpService = keywordListUpService;
    }


    @GetMapping("/rank")
    public KeywordResponse locationSearch() {
        return KeywordResponse.of(keywordListUpService.listUpKeywords());
    }
}
