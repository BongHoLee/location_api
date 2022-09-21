package com.search.infrastructure.repository.keyword;

import com.search.domain.model.keyword.Keywords;
import com.search.domain.repository.KeywordRepository;
import com.search.domain.vo.Search;
import com.search.infrastructure.entity.KeywordEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 *
 * @author o118014_D
 * @since 2022-09-21
 */

@Slf4j
@Repository
public class KeywordDBRepository implements KeywordRepository {

    private final KeywordJPARepository jpaRepository;

    public KeywordDBRepository(KeywordJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Search search) {
        KeywordEntity keyword = jpaRepository.findBySearchKeyword(search);
        if (keyword == null) {
            KeywordEntity save = jpaRepository.save(keyword);
            System.out.println("키워드 첫 생성! " + save);
        } else {
            keyword.increaseSearchCount();
            System.out.println("키워드 카운트 증가! " + keyword);
        }

        System.out.println();
    }

    @Override
    public Keywords findAll() {
        return null;
    }
}
