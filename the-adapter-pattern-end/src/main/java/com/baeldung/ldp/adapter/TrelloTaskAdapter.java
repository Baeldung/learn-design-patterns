package com.baeldung.ldp.adapter;

import java.util.List;

public class TrelloTaskAdapter implements TaskImporter {

    private final TrelloClient trelloClient;

    public TrelloTaskAdapter(TrelloClient trelloClient) {
        this.trelloClient = trelloClient;
    }

    @Override
    public List<Task> importTasks() {
        return trelloClient.fetchCards()
                .stream()
                .map(this::toTask)
                .toList();
    }

    private Task toTask(TrelloCard card) {
        return new Task(
                card.getName(),
                card.getDescription(),
                mapStatus(card.getListName()),
                card.getCardId(),
                "NORMAL");
    }

    private TaskStatus mapStatus(String listName) {
        return switch (listName) {
        case "To Do" -> TaskStatus.TO_DO;
        case "In Progress" -> TaskStatus.IN_PROGRESS;
        case "Done" -> TaskStatus.DONE;
        default -> TaskStatus.TO_DO;
        };
    }
}
