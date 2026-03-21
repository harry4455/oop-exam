package org.eternity.exam;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.eternity.exam.Lecture;
import org.eternity.exam.SerializedLecture;
import org.springframework.stereotype.Component;

@Component
public class CsvLectureFormatter implements LectureFormatter {

    private final CsvMapper csvMapper;

    public CsvLectureFormatter() {
        this.csvMapper = new CsvMapper();
        this.csvMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String type() {
        return "csv";
    }

    @Override
    public SerializedLecture serialize(Lecture lecture) throws Exception {
        CsvSchema schema = csvMapper.schemaFor(Lecture.class).withHeader();
        String content = csvMapper.writer(schema).writeValueAsString(lecture);
        return new SerializedLecture(type(), content, "csv");
    }

}
