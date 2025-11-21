package model;

public class Note {
    private String id;
    private String title;
    private String body;
    private String created;

    public Note(String id, String title, String body, String created) {
        this.id = id; this.title = title; this.body = body; this.created = created;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getBody() { return body; }
    public String getCreated() { return created; }

    @Override
    public String toString() {
        return id + " | " + title + " | " + created;
    }
}

