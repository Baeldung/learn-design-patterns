package com.baeldung.ldp.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingletonPatternUnitTest {

    @BeforeEach
    void setUp() {
        InMemoryTaskRepository.getInstance().clear();
    }

    @Test
    void givenSingletonRepository_whenGetInstanceCalledTwice_thenSameInstance() {
        InMemoryTaskRepository first = InMemoryTaskRepository.getInstance();
        InMemoryTaskRepository second = InMemoryTaskRepository.getInstance();

        assertSame(first, second);

        first.save(1L, new Task(1L, "Deploy release", TaskStatus.TO_DO));

        assertEquals("Deploy release", second.findById(1L).getName());
    }

    @Test
    void givenClearedRepository_whenFindById_thenReturnsNull() {
        InMemoryTaskRepository repo = InMemoryTaskRepository.getInstance();

        assertNull(repo.findById(1L));
    }
}
