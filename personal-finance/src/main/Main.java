package main;

import model.Transaction;
import service.FinanceService;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        FinanceService svc = new FinanceService();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add Tx 2.Total Month 3.Category Summary 4.List 5.Exit");
            String c = in.nextLine();
            if (c.equals("1")) {
                String id = UUID.randomUUID().toString();
                String date = LocalDate.now().toString();
                System.out.print("Category: "); String cat = in.nextLine();
                System.out.print("Amount (+ income, - expense): "); double amt = Double.parseDouble(in.nextLine());
                System.out.print("Note: "); String note = in.nextLine();
                svc.addTransaction(new Transaction(id, date, cat, amt, note));
                System.out.println("Saved.");
            } else if (c.equals("2")) {
                System.out.print("Month (YYYY-MM): "); String m = in.nextLine();
                System.out.println("Total: " + svc.totalForMonth(m));
            } else if (c.equals("3")) {
                System.out.print("Month (YYYY-MM): "); String m = in.nextLine();
                svc.categorySummary(m).forEach((k,v) -> System.out.println(k + ": " + v));
            } else if (c.equals("4")) {
                svc.all().forEach(t -> System.out.println(t.getDate() + " | " + t.getCategory() + " | " + t.getAmount() + " | " + t.getNote()));
            } else break;
        }
    }
}

