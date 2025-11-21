package main;

import model.Note;
import service.NoteService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NoteService svc = new NoteService();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Add 2.List 3.View 4.Search 5.Delete 6.Exit");
            String c = in.nextLine();
            if (c.equals("1")) {
                System.out.print("Title: "); String t = in.nextLine();
                System.out.println("Body (single-line): "); String b = in.nextLine();
                svc.addNote(t,b); System.out.println("Saved.");
            } else if (c.equals("2")) {
                for (Note n : svc.list()) System.out.println(n);
            } else if (c.equals("3")) {
                System.out.print("Note ID: "); String id = in.nextLine();
                Note n = svc.get(id);
                if (n==null) System.out.println("Not found");
                else System.out.println(n.getTitle() + "\n" + n.getBody());
            } else if (c.equals("4")) {
                System.out.print("Query: "); String q = in.nextLine();
                svc.search(q).forEach(System.out::println);
            } else if (c.equals("5")) {
                System.out.print("ID: "); svc.delete(in.nextLine()); System.out.println("Deleted");
            } else break;
        }
    }
}

