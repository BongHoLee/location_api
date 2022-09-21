package com.search.infrastructure.repository.keyword;

import com.search.domain.vo.Search;
import com.search.infrastructure.entity.KeywordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author o118014_D
 * @since 2022-09-21
 */

public interface KeywordJPARepository extends JpaRepository<KeywordEntity, Long> {

    @Query("select k from KeywordEntity k where k.keyword = :#{#searchKeyword.search}")
    KeywordEntity findBySearchKeyword(@Param("searchKeyword") Search searchKeyword);
}
