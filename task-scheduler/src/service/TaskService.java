package service;

import model.Task;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskService {
    private Map<String, Task> tasks = new LinkedHashMap<>();

    public void addTask(Task t) { tasks.put(t.getId(), t); }

    public List<Task> upcoming(int days) {
        LocalDate now = LocalDate.now();
        LocalDate end = now.plusDays(days);
        return tasks.values().stream()
                .filter(t -> !t.isDone() && t.getDue()!=null && !t.getDue().isAfter(end))
                .sorted(Comparator.comparing(Task::getDue))
                .collect(Collectors.toList());
    }

    public List<Task> byUrgency() {
        return tasks.values().stream()
                .filter(t -> !t.isDone())
                .sorted(Comparator.comparing((Task t) -> priorityValue(t.getPriority())).reversed()
                        .thenComparing(t -> t.getDue()==null ? LocalDate.MAX : t.getDue()))
                .collect(Collectors.toList());
    }

    private int priorityValue(String p) {
        switch (p.toLowerCase()) {
            case "high": return 3;
            case "med": return 2;
            default: return 1;
        }
    }

    public Collection<Task> all() { return tasks.values(); }
    public Task get(String id) { return tasks.get(id); }
    public void remove(String id) { tasks.remove(id); }
}

