package com.baeldung.ldp.singleton;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SingletonPatternUnitTest {

    @Test
    void givenMultipleRepositoryInstances_whenSavingToOne_thenOtherCannotFind() {
        InMemoryTaskRepository repoA = new InMemoryTaskRepository();
        InMemoryTaskRepository repoB = new InMemoryTaskRepository();

        repoA.save(1L, new Task(1L, "Write tests", TaskStatus.TO_DO));

        assertNull(repoB.findById(1L));
    }
}
