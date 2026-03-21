package org.eternity.exam;

import org.eternity.exam.SerializedLecture;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLectureStorage implements LectureStorage{

    private final JdbcClient jdbcClient;

    public DatabaseLectureStorage(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public String type() {
        return "database";
    }

    @Override
    public void save(SerializedLecture serializedLecture) throws Exception {
        jdbcClient.sql("INSERT INTO LECTURE(SERIALIZED_DATA) VALUES(?)")
                .param(1, serializedLecture.content())
                .update();
    }
}
