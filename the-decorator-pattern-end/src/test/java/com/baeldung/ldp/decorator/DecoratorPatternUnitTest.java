package com.baeldung.ldp.decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;

class DecoratorPatternUnitTest {

    @Test
    void givenCachingDecorator_whenFindAllCalledTwice_thenReturnsSameData() {
        TaskRepository base = new InMemoryTaskRepository();
        TaskRepository cached = new CachingTaskRepositoryDecorator(base);

        Task task = new Task(1L, "Design review", TaskStatus.TO_DO);
        cached.save(task);

        List<Task> firstCall = cached.findAll();
        List<Task> secondCall = cached.findAll();

        assertEquals(1, firstCall.size());
        assertSame(firstCall, secondCall);
    }

    @Test
    void givenCachingDecorator_whenSaveInvalidatesCache_thenFindAllReturnsFreshData() {
        TaskRepository base = new InMemoryTaskRepository();
        TaskRepository cached = new CachingTaskRepositoryDecorator(base);

        cached.save(new Task(1L, "Design review", TaskStatus.TO_DO));
        List<Task> firstCall = cached.findAll();

        cached.save(new Task(2L, "Code review", TaskStatus.IN_PROGRESS));
        List<Task> afterSecondSave = cached.findAll();

        assertEquals(1, firstCall.size());
        assertEquals(2, afterSecondSave.size());
    }

    @Test
    void givenTimestampingDecorator_whenSave_thenTimestampsAreSet() {
        TaskRepository base = new InMemoryTaskRepository();
        TaskRepository timestamped = new TimestampingTaskRepositoryDecorator(base);

        Task task = new Task(1L, "Design review", TaskStatus.TO_DO);
        timestamped.save(task);

        assertNotNull(task.getCreatedAt());
        assertNotNull(task.getUpdatedAt());
    }

    @Test
    void givenStackedDecorators_whenSaveAndFind_thenBothBehaviorsApply() {
        TaskRepository base = new InMemoryTaskRepository();
        TaskRepository repository = new TimestampingTaskRepositoryDecorator(base);
        repository = new CachingTaskRepositoryDecorator(repository);

        Task task = new Task(1L, "Design review", TaskStatus.TO_DO);
        repository.save(task);

        assertNotNull(task.getCreatedAt());
        assertNotNull(task.getUpdatedAt());
        assertEquals(1, repository.findAll().size());
        assertSame(repository.findAll(), repository.findAll());
    }
}
