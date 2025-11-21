package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<OrderLine> lines = new ArrayList<>();

    public Order() { this.id = UUID.randomUUID().toString().substring(0,8); }

    public void addLine(MenuItem item, int qty) {
        lines.add(new OrderLine(item, qty));
    }

    public double subtotal() {
        return lines.stream().mapToDouble(OrderLine::lineTotal).sum();
    }

    public double tax(double rate) { return subtotal() * rate; }
    public double total(double taxRate, double serviceRate) { return subtotal() + tax(taxRate) + subtotal()*serviceRate; }

    public String getId() { return id; }
    public List<OrderLine> getLines() { return lines; }

    static class OrderLine {
        private MenuItem item; private int qty;
        public OrderLine(MenuItem item, int qty) { this.item = item; this.qty = qty; }
        public double lineTotal() { return item.getPrice() * qty; }
        public String toString() { return qty + "x " + item.getName() + " = Rp " + lineTotal(); }
    }
}

