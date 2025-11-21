package model;

public class Transaction {
    private String id;
    private String date; // YYYY-MM-DD
    private String category;
    private double amount; // positive = income, negative = expense
    private String note;

    public Transaction(String id, String date, String category, double amount, String note) {
        this.id = id; this.date = date; this.category = category; this.amount = amount; this.note = note;
    }

    public String getId() { return id; }
    public String getDate() { return date; }
    public String getCategory() { return category; }
    public double getAmount() { return amount; }
    public String getNote() { return note; }
}

