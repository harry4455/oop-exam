package org.eternity.exam;

import org.eternity.exam.SerializedLecture;

public interface LectureStorage {
    String type();
    void save(SerializedLecture serializedLecture) throws Exception;
}
