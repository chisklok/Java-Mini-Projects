package model;

import java.time.LocalDate;

public class Task {
    private String id;
    private String title;
    private LocalDate due;
    private String priority; // low/med/high
    private boolean done;

    public Task(String id, String title, LocalDate due, String priority) {
        this.id = id; this.title = title; this.due = due; this.priority = priority; this.done = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public LocalDate getDue() { return due; }
    public String getPriority() { return priority; }
    public boolean isDone() { return done; }

    public void markDone() { this.done = true; }

    @Override
    public String toString() {
        return id + " | " + title + " | due: " + (due!=null ? due.toString() : "—") + " | prio: " + priority + " | done: " + done;
    }
}

