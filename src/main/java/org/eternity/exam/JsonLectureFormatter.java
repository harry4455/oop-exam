package org.eternity.exam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;
import org.eternity.exam.Lecture;
import org.eternity.exam.SerializedLecture;

@Component
public class JsonLectureFormatter implements LectureFormatter {
    private final ObjectMapper objectMapper;

    public JsonLectureFormatter() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String type() {
        return "json";
    }

    @Override
    public SerializedLecture serialize(Lecture lecture) throws Exception {
        String content = objectMapper.writeValueAsString(lecture);
        return new SerializedLecture(type(), content, "json");
    }

}
