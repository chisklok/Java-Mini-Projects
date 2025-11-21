package service;

import model.Note;
import util.FileUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class NoteService {
    private Map<String, Note> notes = new LinkedHashMap<>();

    public void addNote(String title, String body) {
        String id = UUID.randomUUID().toString().substring(0,8);
        String created = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        FileUtil.saveNoteFile(id, body);
        Note n = new Note(id, title, body, created);
        notes.put(id, n);
    }

    public Collection<Note> list() { return notes.values(); }

    public Note get(String id) { return notes.get(id); }

    public List<Note> search(String q) {
        q = q.toLowerCase();
        List<Note> res = new ArrayList<>();
        for (Note n : notes.values()) {
            if (n.getTitle().toLowerCase().contains(q) || n.getBody().toLowerCase().contains(q)) res.add(n);
        }
        return res;
    }

    public void delete(String id) { notes.remove(id); }
}

