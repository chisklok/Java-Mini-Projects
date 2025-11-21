package service;

import model.Transaction;
import util.JsonUtil;

import java.util.*;
import java.util.stream.Collectors;

public class FinanceService {
    private List<Transaction> transactions;

    public FinanceService() {
        transactions = JsonUtil.loadTransactions();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        JsonUtil.saveTransactions(transactions);
    }

    public double totalForMonth(String yyyyMM) {
        return transactions.stream()
                .filter(t -> t.getDate().startsWith(yyyyMM))
                .mapToDouble(Transaction::getAmount).sum();
    }

    public Map<String, Double> categorySummary(String yyyyMM) {
        return transactions.stream()
                .filter(t -> t.getDate().startsWith(yyyyMM))
                .collect(Collectors.groupingBy(Transaction::getCategory,
                        Collectors.summingDouble(Transaction::getAmount)));
    }

    public List<Transaction> listSortedByAmount(boolean asc) {
        return transactions.stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .collect(Collectors.toList());
    }

    public List<Transaction> all() { return transactions; }
}

