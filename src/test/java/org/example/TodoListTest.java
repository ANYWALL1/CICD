package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest {

    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add("   ");
        assertEquals(0, t.size());
    }

    @Test
    void clear() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        t.clear();
        assertEquals(0, t.size());
    }

    @Test
    void done() {
        TodoList t = new TodoList();
        t.add("task");
        assertTrue(t.done(0));
        assertEquals("[DONE] task", t.getAll().getFirst());
        assertFalse(t.done(10));
    }

    @Test
    void search() {
        TodoList t = new TodoList();
        t.add("Buy milk");
        t.add("Buy bread");
        t.add("Read book");
        
        List<String> results = t.search("buy");
        assertEquals(2, results.size());
        assertTrue(results.contains("Buy milk"));
        
        List<String> noResults = t.search("water");
        assertEquals(0, noResults.size());
    }
}
