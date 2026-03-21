package org.eternity.exam;

import org.springframework.stereotype.Service;
import org.eternity.exam.Lecture;
import org.eternity.exam.LectureFormatter;
import org.eternity.exam.LectureStorage;
import org.eternity.exam.FormatterRegistry;
import org.eternity.exam.StorageRegistry;

@Service
public class LectureReportService {
    private final FormatterRegistry formatterRegistry;
    private final StorageRegistry storageRegistry;

    public LectureReportService(FormatterRegistry formatterRegistry, StorageRegistry storageRegistry) {
        this.formatterRegistry = formatterRegistry;
        this.storageRegistry = storageRegistry;
    }

    public void report(ReportRequest request, Lecture lecture) throws Exception {
        LectureFormatter formatter = formatterRegistry.get(request.format());
        LectureStorage storage = storageRegistry.get(request.storage());

        SerializedLecture serializedLecture = formatter.serialize(lecture);
        storage.save(serializedLecture);
    }
}
