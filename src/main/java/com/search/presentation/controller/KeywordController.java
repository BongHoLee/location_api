package com.search.presentation.controller;

import com.search.domain.service.keyword.KeywordListUpService;
import com.search.presentation.response.KeywordResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



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
