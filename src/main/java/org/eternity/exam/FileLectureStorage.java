package org.eternity.exam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class FileLectureStorage implements LectureStorage{

    private final String baseFileName;

    public FileLectureStorage(@Value("${lecture.file.name:lecture") String baseFileName) {
        this.baseFileName = baseFileName;
    }

    @Override
    public String type() {
        return "file";
    }

    @Override
    public void save(SerializedLecture serializedLecture) throws Exception {
        Path path = Path.of(baseFileName + "." + serializedLecture.extension());

        Files.writeString(
                path,
                serializedLecture.content()
        );
    }
}
