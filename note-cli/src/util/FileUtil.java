package util;

import java.io.*;
import java.nio.file.*;
import java.util.UUID;

public class FileUtil {
    public static void ensureNotes() {
        try { Files.createDirectories(Paths.get("notes")); } catch (IOException ignored) {}
    }

    public static String saveNoteFile(String id, String content) {
        ensureNotes();
        String path = "notes/" + id + ".md";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(content);
        } catch (IOException ignored) {}
        return path;
    }

    public static String loadNoteFile(String id) {
        String path = "notes/" + id + ".md";
        try { return new String(Files.readAllBytes(Paths.get(path))); } catch (IOException e) { return ""; }
    }
}

