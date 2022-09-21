package com.search.infrastructure.repository.keyword;

import static java.util.stream.Collectors.toList;

import com.search.domain.model.keyword.Keywords;
import com.search.domain.repository.KeywordRepository;
import com.search.domain.vo.Search;
import com.search.infrastructure.entity.KeywordEntity;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author o118014_D
 * @since 2022-09-21
 */

@Slf4j
@Repository
public class DBKeywordRepository implements KeywordRepository {

    private final JPAKeywordRepository jpaRepository;

    public DBKeywordRepository(JPAKeywordRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Search search) {
        jpaRepository.findBySearchKeyword(search)
                .ifPresentOrElse(KeywordEntity::increaseSearchCount,
                        () -> jpaRepository.save(KeywordEntity.builder().keyword(search.getSearch()).build()));

    }

    @Override
    public Keywords findAll() {
        List<KeywordEntity> allKeywords = jpaRepository.findAll();
        return new Keywords(allKeywords.stream().map(KeywordEntity::convert).collect(toList()));
    }
}
