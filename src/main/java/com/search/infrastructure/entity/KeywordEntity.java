package com.search.infrastructure.entity;

import com.search.domain.model.keyword.Keyword;
import com.search.domain.vo.Search;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class KeywordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "keyword", nullable = false, unique = true)
    private String keyword;

    @Column(name = "search_count", nullable = false)
    private Long searchCount;

    @Builder
    public KeywordEntity(Long id, String keyword, Long searchCount) {
        this.id = id;
        this.keyword = keyword;
        this.searchCount = searchCount;
    }

    @PrePersist
    private void initSearchCount() {
        this.searchCount = 1L;
    }

    public void increaseSearchCount() {
        searchCount += 1;
    }

    public Keyword convert() {
        return new Keyword(id, keyword, searchCount);
    }
}
