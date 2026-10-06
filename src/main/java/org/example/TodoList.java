package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoList {
    private final List<String> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(item);
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public List<String> getAll() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public boolean done(int index) {
        if (index >= 0 && index < items.size()) {
            String item = items.get(index);
            if (!item.startsWith("[DONE] ")) {
                items.set(index, "[DONE] " + item);
            }
            return true;
        }
        return false;
    }

    public List<String> search(String query) {
        if (query == null || query.isEmpty()) {
            return new ArrayList<>();
        }
        String lowerQuery = query.toLowerCase();
        return items.stream()
                .filter(item -> item.toLowerCase().contains(lowerQuery))
                .collect(Collectors.toList());
    }
}
