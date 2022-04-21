package io.digiwise.ihmmt.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Event {

    private long id;
    private String title;

    @DateTimeFormat(fallbackPatterns = "YYYY-MM-dd")
    private LocalDate date;
    private LocalDate date2;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate2() {
        return date2;
    }

    public void setDate2(LocalDate date2) {
        this.date2 = date2;
    }

    public Event(){}

    public Event(long id, String title, LocalDate date) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.date2 = date.minusMonths(1);
    }
}
