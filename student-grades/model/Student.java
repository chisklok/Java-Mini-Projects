package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String id;
    private String name;
    private List<Grade> grades = new ArrayList<>();

    public Student(String id, String name) { this.id = id; this.name = name; }

    public String getId() { return id; }
    public String getName() { return name; }
    public List<Grade> getGrades() { return grades; }

    public void addGrade(Grade g) { grades.add(g); }

    public double average() {
        return grades.stream().mapToDouble(Grade::getScore).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | avg: " + String.format("%.2f", average());
    }
}
