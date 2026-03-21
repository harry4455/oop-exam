package org.eternity.exam;

import org.eternity.exam.Lecture;
import org.eternity.exam.SerializedLecture;

public interface LectureFormatter {
    String type();
//    SerializedLecture serialize(Lecture lecture) throws Exception;
    SerializedLecture serialize(Lecture lecture) throws Exception;
}
