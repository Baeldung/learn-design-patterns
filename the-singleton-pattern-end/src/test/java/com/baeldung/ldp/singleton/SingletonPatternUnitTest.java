package com.baeldung.ldp.singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingletonPatternUnitTest {

    @BeforeEach
    void setUp() {
        InMemoryTaskRepositorySingleton.getInstance().clear();
    }

    @Test
    void givenMultipleRepositoryInstances_whenSavingToOne_thenOtherCannotFind() {
        InMemoryTaskRepository repoA = new InMemoryTaskRepository();
        InMemoryTaskRepository repoB = new InMemoryTaskRepository();

        repoA.save(1L, new Task(1L, "Write tests", TaskStatus.TO_DO));

        assertNull(repoB.findById(1L));
    }

    @Test
    void givenSingletonRepository_whenGetInstanceCalledTwice_thenSameInstance() {
        InMemoryTaskRepositorySingleton first = InMemoryTaskRepositorySingleton.getInstance();
        InMemoryTaskRepositorySingleton second = InMemoryTaskRepositorySingleton.getInstance();

        assertSame(first, second);

        first.save(1L, new Task(1L, "Deploy release", TaskStatus.TO_DO));

        assertEquals("Deploy release", second.findById(1L).getName());
    }

    @Test
    void givenEnumSingleton_whenAccessedTwice_thenSameInstanceAndConsecutiveIds() {
        TaskIdGenerator first = TaskIdGenerator.INSTANCE;
        TaskIdGenerator second = TaskIdGenerator.INSTANCE;

        assertSame(first, second);

        long id1 = first.nextId();
        long id2 = second.nextId();

        assertEquals(id1 + 1, id2);
    }

    @Test
    void givenClearedRepository_whenFindById_thenReturnsNull() {
        InMemoryTaskRepositorySingleton repo = InMemoryTaskRepositorySingleton.getInstance();

        assertNull(repo.findById(1L));
    }
}
