package com.baeldung.ldp.adapter;

import java.util.ArrayList;
import java.util.List;

public class TrelloClient {

    private final List<TrelloCard> cards = new ArrayList<>();

    public TrelloClient() {
        cards.add(new TrelloCard("card-1", "Design homepage",
                "Create wireframes for the new homepage", "To Do"));
        cards.add(new TrelloCard("card-2", "Implement login",
                "Build the authentication module", "In Progress"));
        cards.add(new TrelloCard("card-3", "Write tests",
                "Add unit tests for the service layer", "Done"));
    }

    public List<TrelloCard> fetchCards() {
        return List.copyOf(cards);
    }

    public void addCard(TrelloCard card) {
        cards.add(card);
    }
}
