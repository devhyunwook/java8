package com.devhwkang.java8;

public class OnlineClass {
    private Integer id;

    private String title;

    private boolean closed;

    private Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Progress getProgress() {
        return this.progress;
    }
}
