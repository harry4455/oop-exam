package org.eternity.exam;

import org.springframework.stereotype.Component;
import org.eternity.exam.LectureFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StorageRegistry {
    private final Map<String, LectureStorage> storageMap;

    public StorageRegistry(List<LectureStorage> storages) {
        this.storageMap = storages.stream()
                .collect(Collectors.toUnmodifiableMap(
                        storage -> storage.type().toLowerCase(),
                        Function.identity()
                ));
    }

    public LectureStorage get(String storage) {
        LectureStorage lectureStorage = storageMap.get(storage.toLowerCase());
        if (lectureStorage == null) {
            throw new IllegalArgumentException(storage + " not found");
        }
        return lectureStorage;
    }
}
