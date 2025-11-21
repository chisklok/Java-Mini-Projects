package service;

import model.MenuItem;
import model.Order;

import java.util.*;

public class OrderService {
    private Map<String, MenuItem> menu = new LinkedHashMap<>();

    public OrderService() {
        // seed menu
        menu.put("M01", new MenuItem("M01", "Nasi Goreng", 20000));
        menu.put("M02", new MenuItem("M02", "Mie Ayam", 15000));
        menu.put("D01", new MenuItem("D01", "Es Teh", 5000));
    }

    public void showMenu() { menu.values().forEach(System.out::println); }
    public MenuItem find(String code) { return menu.get(code); }

    public String buildReceipt(Order o, double taxRate, double serviceRate) {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(o.getId()).append("\n");
        for (Order.OrderLine l : o.getLines()) sb.append(l).append("\n");
        sb.append(String.format("Subtotal: Rp %.0f\n", o.subtotal()));
        sb.append(String.format("Tax: Rp %.0f\n", o.tax(taxRate)));
        sb.append(String.format("Service: Rp %.0f\n", o.subtotal()*serviceRate));
        sb.append(String.format("Total: Rp %.0f\n", o.total(taxRate, serviceRate)));
        return sb.toString();
    }
}

