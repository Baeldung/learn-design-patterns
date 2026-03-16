package com.baeldung.ldp.adapter;

public class TrelloCard {

    private final String cardId;
    private final String name;
    private final String description;
    private final String listName;

    public TrelloCard(String cardId, String name, String description, String listName) {
        this.cardId = cardId;
        this.name = name;
        this.description = description;
        this.listName = listName;
    }

    public String getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getListName() {
        return listName;
    }
}
