package com.baeldung.ldp.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdapterPatternUnitTest {

    private TaskImporter taskImporter;

    @BeforeEach
    void setUp() {
        taskImporter = new TrelloTaskAdapter(new TrelloClient());
    }

    @Test
    void givenTrelloCard_whenImportTasks_thenFieldsMappedCorrectly() {
        List<Task> tasks = taskImporter.importTasks();

        Task first = tasks.getFirst();
        assertEquals("Design homepage", first.getTitle());
        assertEquals("Create wireframes for the new homepage", first.getDescription());
        assertEquals(TaskStatus.TO_DO, first.getStatus());
        assertEquals("card-1", first.getSourceId());
        assertEquals("NORMAL", first.getPriority());
    }

    @Test
    void givenMultipleTrelloCards_whenImportTasks_thenAllMapped() {
        List<Task> tasks = taskImporter.importTasks();

        assertEquals(3, tasks.size());
        assertEquals("Design homepage", tasks.get(0).getTitle());
        assertEquals("Implement login", tasks.get(1).getTitle());
        assertEquals("Write tests", tasks.get(2).getTitle());
    }

    @Test
    void givenUnrecognizedListName_whenImportTasks_thenDefaultStatus() {
        TrelloClient client = new TrelloClient();
        client.addCard(
                new TrelloCard("card-99", "Review task", "Needs review", "Review"));
        TaskImporter importer = new TrelloTaskAdapter(client);

        List<Task> tasks = importer.importTasks();

        Task reviewTask = tasks.getLast();
        assertEquals(TaskStatus.TO_DO, reviewTask.getStatus());
    }
}
