package com.baeldung.ldp.proxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProxyPatternUnitTest {

    @Test
    void givenAdminUser_whenDeleteTask_thenTaskIsRemoved() {
        TaskRepository realRepo = new InMemoryTaskRepository();
        UserContext adminContext = new UserContext(UserRole.ADMIN);
        TaskRepository proxy = new SecurityProxyRepository(realRepo,
          adminContext);

        proxy.save(new Task(1L, "Design review", TaskStatus.TO_DO));
        proxy.deleteTask(1L);

        assertTrue(proxy.findAll().isEmpty());
    }

    @Test
    void givenNonAdminUser_whenDeleteTask_thenThrowsSecurityException() {
        TaskRepository realRepo = new InMemoryTaskRepository();
        UserContext userContext = new UserContext(UserRole.USER);
        TaskRepository proxy = new SecurityProxyRepository(realRepo,
          userContext);

        proxy.save(new Task(1L, "Design review", TaskStatus.TO_DO));

        assertThrows(SecurityException.class,
          () -> proxy.deleteTask(1L));
    }

    @Test
    void givenNonAdminUser_whenSaveAndFindAll_thenOperationsSucceed() {
        TaskRepository realRepo = new InMemoryTaskRepository();
        UserContext userContext = new UserContext(UserRole.USER);
        TaskRepository proxy = new SecurityProxyRepository(realRepo,
          userContext);

        proxy.save(new Task(1L, "Design review", TaskStatus.TO_DO));

        assertEquals(1, proxy.findAll().size());
    }
}
