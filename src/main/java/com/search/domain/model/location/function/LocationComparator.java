package com.search.domain.model.location.function;

import com.search.domain.model.location.Location;
import java.util.Comparator;

public interface LocationComparator {
    Comparator<Location> compare();
}
