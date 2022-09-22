package com.search.presentation.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String springdocVersion) {
        Info info = new Info()
                .title("장소 검색 API")
                .version(springdocVersion)
                .description("주어진 키워드로 장소를 검색하고 인기 검색어를 조회합니다.");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}
