package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Transaction;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {
    private static final String FILE = "transactions.json";
    private static final Gson gson = new Gson();

    public static List<Transaction> loadTransactions() {
        try (Reader r = new FileReader(FILE)) {
            Type tt = new TypeToken<List<Transaction>>(){}.getType();
            List<Transaction> list = gson.fromJson(r, tt);
            return list != null ? list : new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public static void saveTransactions(List<Transaction> list) {
        try (Writer w = new FileWriter(FILE)) {
            gson.toJson(list, w);
        } catch (IOException ignored) {}
    }
}

