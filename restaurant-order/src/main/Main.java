package main;

import model.MenuItem;
import model.Order;
import service.OrderService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderService svc = new OrderService();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Show menu 2.New order 3.Exit");
            String c = in.nextLine();
            if (c.equals("1")) svc.showMenu();
            else if (c.equals("2")) {
                Order o = new Order();
                while (true) {
                    System.out.print("Menu code (or done): ");
                    String code = in.nextLine();
                    if (code.equalsIgnoreCase("done")) break;
                    MenuItem mi = svc.find(code);
                    if (mi == null) { System.out.println("Kode invalid."); continue; }
                    System.out.print("Qty: "); int q = Integer.parseInt(in.nextLine());
                    o.addLine(mi, q);
                }
                String receipt = svc.buildReceipt(o, 0.1, 0.05);
                System.out.println("\n=== RECEIPT ===");
                System.out.println(receipt);
            } else break;
        }
    }
}

