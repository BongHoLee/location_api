package com.search.domain.model.location;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
public class Address {
    private final String locationAddress;
    private final String roadAddress;

    public Address(String locationAddress, String roadAddress) {
        this.locationAddress = locationAddress;
        this.roadAddress = roadAddress;
    }

    /**
     * 경남, 경상남도
     * 경북, 경상북도
     * 충남, 충청남도
     * 충북, 충청북도
     * 전남, 전라남도
     * 전북, 전라북도
     * 경기, 경기도
     * 강원, 강원도
     * 서울시, 서울특별시
     * 제주특별자치도
     * 인천, 인천광역시
     * 대전, 대전광역시
     *
     */
}
