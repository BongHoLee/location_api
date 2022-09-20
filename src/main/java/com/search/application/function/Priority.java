package com.search.application.function;

import com.search.domain.model.location.Source;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "priority")
@Getter @Setter
public class Priority {
    private Map<Source, Integer> priority;

    public int priorityOf(Source source) {
        return priority.get(source);
    }
}
