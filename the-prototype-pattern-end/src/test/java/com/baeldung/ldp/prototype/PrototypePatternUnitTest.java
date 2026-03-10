package com.baeldung.ldp.prototype;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PrototypePatternUnitTest {

    @Test
    void givenCampaign_whenCopy_thenCopyHasSameData() {
        Campaign original = new Campaign("Spring Launch", "Q1 campaign");
        original.addTask(new Task("Write blog post", LocalDate.of(2050, 1, 15), TaskStatus.TO_DO));
        original.addTask(new Task("Send newsletter", LocalDate.of(2050, 1, 20), TaskStatus.TO_DO));

        Campaign copy = original.copy();

        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getDescription(), copy.getDescription());
        assertEquals(original.getTasks().size(), copy.getTasks().size());
    }

    @Test
    void givenCopiedCampaign_whenModifyCopyTask_thenOriginalUnchanged() {
        Campaign original = new Campaign("Spring Launch", "Q1 campaign");
        original.addTask(new Task("Write blog post", LocalDate.of(2050, 1, 15), TaskStatus.TO_DO));

        Campaign copy = original.copy();
        copy.getTasks().get(0).setName("Updated task");

        assertEquals("Write blog post", original.getTasks().get(0).getName());
        assertNotSame(original.getTasks().get(0), copy.getTasks().get(0));
    }
}
