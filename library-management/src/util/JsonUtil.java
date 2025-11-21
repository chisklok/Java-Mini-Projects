package util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Book;
import java.io.*;
import java.util.*;

public class JsonUtil {

    private static final String FILE = "books.json";

    public static List<Book> loadBooks() {
        try {
            Reader reader = new FileReader(FILE);
            return new Gson().fromJson(reader, new TypeToken<List<Book>>(){}.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public static void saveBooks(List<Book> books) {
        try (Writer writer = new FileWriter(FILE)) {
            new Gson().toJson(books, writer);
        } catch (Exception ignored) {}
    }
}

