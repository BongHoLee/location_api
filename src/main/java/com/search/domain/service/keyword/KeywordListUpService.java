package com.search.domain.service.keyword;

import com.search.application.dto.KeywordDTO;
import com.search.domain.model.keyword.Keywords;
import java.util.List;

public interface KeywordListUpService {
    List<KeywordDTO> listUpKeywords();
}
