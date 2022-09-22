package com.search.application.location.function;

import com.search.application.service.location.function.Priority;
import com.search.application.service.location.function.SortByTitleProcessor;
import com.search.domain.model.location.Address;
import com.search.domain.model.location.Location;
import com.search.domain.model.location.Locations;
import com.search.domain.model.location.Source;
import com.search.domain.model.location.Title;
import java.util.ArrayList;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortByTitleProcessorTest {
    Priority priority;

    @BeforeEach
    void set() {
        priority = new Priority(new ArrayList<>(Arrays.asList("kakao", "naver")));
    }

    @Test
    void 타이틀_비교에따른_정렬_테스트() {
        Locations locations = locations();
        SortByTitleProcessor sortByTitleProcessor = new SortByTitleProcessor(priority);
        Locations processed = locations.postProcessBy(sortByTitleProcessor);

        Assertions.assertThat(processed.getLocations())
                .hasSize(5)
                .containsExactly(
                        new Location(new Source("kakao"), new Title("A"), new Address("A-1", "A-1-01")),
                        new Location(new Source("kakao"), new Title("C"), new Address("C-1", "C-1-01")),
                        new Location(new Source("kakao"), new Title("D"), new Address("D-1", "D-1-01")),
                        new Location(new Source("kakao"), new Title("B"), new Address("B-1", "B-1-01")),
                        new Location(new Source("naver"), new Title("E"), new Address("E-1", "E-1-01")));
    }


    private Locations locations() {
        return new Locations(new ArrayList<>(
                Arrays.asList(
                        new Location(new Source("kakao"), new Title("A"), new Address("A-1", "A-1-01")),
                        new Location(new Source("kakao"), new Title("B"), new Address("B-1", "B-1-01")),
                        new Location(new Source("kakao"), new Title("C"), new Address("C-1", "C-1-01")),
                        new Location(new Source("kakao"), new Title("D"), new Address("D-1", "D-1-01")),

                        new Location(new Source("naver"), new Title("A"), new Address("A-1", "A-1-01")),
                        new Location(new Source("naver"), new Title("E"), new Address("E-1", "E-1-01")),
                        new Location(new Source("naver"), new Title("D"), new Address("D-1", "D-1-01")),
                        new Location(new Source("naver"), new Title("C"), new Address("C-1", "C-1-01"))
                )));
    }
}