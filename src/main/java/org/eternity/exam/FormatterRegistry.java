package org.eternity.exam;

import org.springframework.stereotype.Component;
import org.eternity.exam.LectureFormatter;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


@Component
public class FormatterRegistry {
    private final Map<String, LectureFormatter> formatterMap;

    public FormatterRegistry(List<LectureFormatter> formatters) {
        this.formatterMap = formatters.stream()
                .collect(Collectors.toUnmodifiableMap(
                        formatter -> formatter.type().toLowerCase(),
                        Function.identity()
                ));
    }

    public LectureFormatter get(String format) {
        LectureFormatter formatter = formatterMap.get(format.toLowerCase());
        if (formatter == null) {
            throw new IllegalArgumentException(format + " not found");
        }
        return formatter;
    }
}
