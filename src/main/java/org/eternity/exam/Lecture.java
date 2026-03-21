package org.eternity.exam;

import java.time.LocalDate;
import java.util.Objects;

public class Lecture {
    private final String title;
    private final LocalDate date;
    private final int days;

    public Lecture(String title, LocalDate date, int days) {
        this.title = title;
        this.date = date;
        this.days = days;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDays() {
        return days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if(!(o instanceof Lecture lecture)) {
            return false;
        }
        return days == lecture.days && Objects.equals(title, lecture.title) && Objects.equals(date, lecture.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, days);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", days=" + days +
                '}';
    }
}