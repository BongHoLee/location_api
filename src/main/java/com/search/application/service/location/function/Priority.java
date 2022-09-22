package com.search.application.service.location.function;

import com.search.domain.model.location.Source;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "function")
@Getter @Setter
public class Priority {
    private List<String> priorities;

    public Priority(){}
    public Priority(List<String> priorities) {
        this.priorities = priorities;
    }

    public int priorityOf(Source source) {
        return priorities.indexOf(source.getSourceName());
    }

    public Source getSourceOf(int idx) {
        return new Source(priorities.get(idx));
    }

    public int numberOfPriority() {
        return priorities.size();
    }
}
