package com.baeldung.ldp.prototype;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class PrototypePatternUnitTest {

    @Test
    void givenShallowCopy_whenModifyingCopyTasks_thenOriginalIsAffected() {
        Campaign original = new Campaign();
        original.setName("Summer Sale");
        original.setCode("SUMMER-2050");

        Task task = new Task(1L, "Design banner", TaskStatus.TO_DO);
        original.setTasks(new HashSet<>(Set.of(task)));

        Campaign copy = new Campaign();
        copy.setName(original.getName());
        copy.setCode("COPY-" + original.getCode());
        copy.setTasks(original.getTasks());

        copy.getTasks().add(new Task(2L, "Write copy", TaskStatus.TO_DO));

        assertEquals(original.getTasks().size(), copy.getTasks().size());
    }

    @Test
    void givenDeepCopy_whenModifyingCopiedTask_thenOriginalIsUnchanged() {
        Campaign original = new Campaign();
        original.setName("Summer Sale");
        original.setCode("SUMMER-2050");

        Task task = new Task(1L, "Design banner", TaskStatus.TO_DO);
        original.setTasks(new HashSet<>(Set.of(task)));

        Campaign copy = new Campaign(original);

        copy.getTasks().iterator().next().setStatus(TaskStatus.DONE);

        assertEquals(TaskStatus.TO_DO, original.getTasks().iterator().next().getStatus());
    }

    @Test
    void givenDeepCopy_whenAddingTaskToCopy_thenOriginalSetIsUnchanged() {
        Campaign original = new Campaign();
        original.setName("Summer Sale");
        original.setCode("SUMMER-2050");

        Task task = new Task(1L, "Design banner", TaskStatus.TO_DO);
        original.setTasks(new HashSet<>(Set.of(task)));

        Campaign copy = new Campaign(original);
        copy.getTasks().add(new Task(2L, "Write copy", TaskStatus.TO_DO));

        assertEquals(1, original.getTasks().size());
        assertEquals(2, copy.getTasks().size());
    }
}
