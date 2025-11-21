package service;

import model.Student;
import model.Grade;
import util.JsonUtil;

import java.util.*;

public class GradeService {
    private Map<String, Student> students;

    public GradeService() {
        students = JsonUtil.loadStudents();
    }

    public void addStudent(String id, String name) {
        students.putIfAbsent(id, new Student(id, name));
        JsonUtil.saveStudents(students);
    }

    public boolean addGrade(String studentId, Grade g) {
        Student s = students.get(studentId);
        if (s == null) return false;
        s.addGrade(g);
        JsonUtil.saveStudents(students);
        return true;
    }

    public List<Student> ranking() {
        List<Student> list = new ArrayList<>(students.values());
        list.sort((a,b) -> Double.compare(b.average(), a.average()));
        return list;
    }

    public Collection<Student> all() { return students.values(); }
}

