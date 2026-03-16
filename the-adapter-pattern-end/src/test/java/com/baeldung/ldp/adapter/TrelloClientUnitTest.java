package com.baeldung.ldp.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class TrelloClientUnitTest {

    @Test
    void givenTrelloClient_whenFetchCards_thenReturnsExpectedCards() {
        TrelloClient client = new TrelloClient();

        List<TrelloCard> cards = client.fetchCards();

        assertEquals(3, cards.size());
        assertEquals("card-1", cards.get(0).getCardId());
        assertEquals("Design homepage", cards.get(0).getName());
        assertEquals("card-2", cards.get(1).getCardId());
        assertEquals("Implement login", cards.get(1).getName());
        assertEquals("card-3", cards.get(2).getCardId());
        assertEquals("Write tests", cards.get(2).getName());
    }
}
