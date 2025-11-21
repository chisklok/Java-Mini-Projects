package main;

import model.Task;
import service.TaskService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        TaskService svc = new TaskService();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add 2.List 3.Upcoming 4.Urgent 5.MarkDone 6.Exit");
            String c = in.nextLine();
            if (c.equals("1")) {
                String id = UUID.randomUUID().toString().substring(0,8);
                System.out.print("Title: "); String t = in.nextLine();
                System.out.print("Due (YYYY-MM-DD) or enter: "); String d = in.nextLine();
                LocalDate due = d.isEmpty() ? null : LocalDate.parse(d);
                System.out.print("Priority (low/med/high): "); String p = in.nextLine();
                svc.addTask(new Task(id,t,due,p));
            } else if (c.equals("2")) svc.all().forEach(System.out::println);
            else if (c.equals("3")) svc.upcoming(3).forEach(System.out::println);
            else if (c.equals("4")) svc.byUrgency().forEach(System.out::println);
            else if (c.equals("5")) {
                System.out.print("Task ID: "); String id = in.nextLine();
                Task tk = svc.get(id);
                if (tk != null) { tk.markDone(); System.out.println("Marked."); } else System.out.println("Not found.");
            } else break;
        }
    }
}

