package org.eternity.exam;

import org.eternity.exam.LectureReportService;
import org.eternity.exam.ReportRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    private final LectureReportService lectureReportService;

    public MainApplication(LectureReportService lectureReportService) {
        this.lectureReportService = lectureReportService;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Lecture lecture = new Lecture(
                "객체지향 설계",
                LocalDate.of(2026, 3, 21),
                3
        );

        lectureReportService.report(
                new ReportRequest("json", "file"),
                lecture
        );
    }
}
