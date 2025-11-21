package util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.Grade;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class JsonUtil {
    private static final String FILE = "students.json";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Map<String, Student> loadStudents() {
        try (Reader r = new FileReader(FILE)) {
            Type type = new TypeToken<Map<String, Student>>(){}.getType();
            Map<String, Student> map = gson.fromJson(r, type);
            return map != null ? map : new HashMap<>();
        } catch (IOException e) {
            return new HashMap<>();
        }
    }

    public static void saveStudents(Map<String, Student> students) {
        try (Writer w = new FileWriter(FILE)) {
            gson.toJson(students, w);
        } catch (IOException ignored) {}
    }
}

