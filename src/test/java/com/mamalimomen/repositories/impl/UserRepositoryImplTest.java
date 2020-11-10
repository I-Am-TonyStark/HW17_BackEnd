package com.mamalimomen.repositories.impl;

import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Tag("repository")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryImplTest {

    @BeforeAll
    static void beforeAll() {

    }

    @AfterAll
    static void afterAll() {

    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    @DisplayName("Find one user by username")
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    void findOneUserByUsername() {
        assertFalse(false);
        assertTrue(true);
        assertEquals(1,1);
        fail();
    }
}