package org.carpio.aerlyapi.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceNotFoundTest {

    @Test
    @DisplayName("ResourceNotFound should store the message correctly")
    void resourceNotFound_StoresMessageCorrectly() {
        String errorMessage = "Resource not found with id: 1";

        ResourceNotFound exception = new ResourceNotFound(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    @DisplayName("ResourceNotFound should be a RuntimeException")
    void resourceNotFound_IsRuntimeException() {
        ResourceNotFound exception = new ResourceNotFound("Test");

        assertTrue(exception instanceof RuntimeException);
    }

    @Test
    @DisplayName("ResourceNotFound can be thrown and caught")
    void resourceNotFound_CanBeThrownAndCaught() {
        String errorMessage = "Test error message";

        Exception caughtException = assertThrows(ResourceNotFound.class, () -> {
            throw new ResourceNotFound(errorMessage);
        });

        assertEquals(errorMessage, caughtException.getMessage());
    }
}
