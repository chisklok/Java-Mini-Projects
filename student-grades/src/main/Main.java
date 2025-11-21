package main;

import model.Grade;
import model.Student;
import service.GradeService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GradeService svc = new GradeService();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add Student 2.Add Grade 3.List 4.Ranking 5.Exit");
            String c = in.nextLine();
            if (c.equals("1")) {
                System.out.print("ID: "); String id = in.nextLine();
                System.out.print("Name: "); String name = in.nextLine();
                svc.addStudent(id, name);
            } else if (c.equals("2")) {
                System.out.print("Student ID: "); String id = in.nextLine();
                System.out.print("Subject: "); String sub = in.nextLine();
                System.out.print("Score: "); double sc = Double.parseDouble(in.nextLine());
                svc.addGrade(id, new Grade(sub, sc));
            } else if (c.equals("3")) {
                for (Student s : svc.all()) System.out.println(s);
            } else if (c.equals("4")) {
                for (Student s : svc.ranking()) System.out.println(s);
            } else break;
        }
    }
}
