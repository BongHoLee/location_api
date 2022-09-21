package com.search.application.function;

import static java.util.stream.Collectors.toList;

import com.search.domain.model.location.Location;
import com.search.domain.model.location.Locations;
import com.search.domain.model.location.Source;
import com.search.domain.model.location.function.LocationsPostProcessor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

/**
 * Title과 Priority를 기준으로 정렬하는 후처리기
 *
 * @author o118014_D
 * @since 2022-09-21
 */

@Component
public class SortByTitleProcessor implements LocationsPostProcessor {
    private final Priority priority;

    public SortByTitleProcessor(Priority priority) {
        this.priority = priority;
    }

    @Override
    public Locations postProcess(final Locations originLocations) {
        List<Pair<Location, Integer>> countList = createMatchCountListByPriority(groupingBySource(originLocations));

        countList.sort((beforePair, afterPair) -> {
            if (beforePair.getSecond().compareTo(afterPair.getSecond()) != 0) {
                return afterPair.getSecond() - beforePair.getSecond();
            } else {
                Location beforeLocation = beforePair.getFirst();
                Location afterLocation = afterPair.getFirst();

                return Integer.compare(
                        priority.priorityOf(beforeLocation.getSource()),
                        priority.priorityOf(afterLocation.getSource())
                );
            }
        });

        return new Locations(countList.stream().map(Pair::getFirst).limit(5).collect(toList()));
    }

    private Map<Source, List<Location>> groupingBySource(final Locations originLocations) {
        return originLocations.getLocations()
                .stream()
                .collect(Collectors.groupingBy(Location::getSource));
    }

    private List<Pair<Location, Integer>> createMatchCountListByPriority(Map<Source, List<Location>> groupingBySource) {
        List<Pair<Location, Integer>> countList = new ArrayList<>();

        for (int i = 0; i < priority.numberOfPriority(); i++) {
            List<Location> higherPriority = groupingBySource.get(priority.getSourceOf(i));

            for (Location higherPriorityLocation : higherPriority) {
                int count = 1;

                for (int j = i + 1; j < priority.numberOfPriority(); j++) {
                    List<Location> lowerPriority = groupingBySource.get(priority.getSourceOf(j));

                    if (lowerPriority.contains(higherPriorityLocation)) {
                        lowerPriority.remove(higherPriorityLocation);
                        count++;
                    }
                }

                countList.add(Pair.of(higherPriorityLocation, count));
            }
        }

        return countList;
    }
}
