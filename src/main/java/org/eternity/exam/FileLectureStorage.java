package org.eternity.exam;

import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;

import org.eternity.exam.SerializedLecture;

@Component
public class FileLectureStorage implements LectureStorage{

    private final String baseFileName;

    public FileLectureStorage(String baseFileName) {
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
