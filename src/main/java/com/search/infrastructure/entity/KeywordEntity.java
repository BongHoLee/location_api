package com.search.infrastructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Class desc.
 *
 * @author o118014_D
 * @since 2022-09-21
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class KeywordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "keyword", nullable = false)
    private String keyword;

    @Column(name = "search_count", nullable = false)
    private Long searchCount;

    @PrePersist
    private void initSearchCount() {
        this.searchCount = 1L;
    }

    public void increaseSearchCount() {
        searchCount += 1;
    }
}
