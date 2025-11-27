package org.carpio.aerlyapi.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionHandleControllerTest {

    private final ExceptionHandleController exceptionHandleController = new ExceptionHandleController();

    @Test
    @DisplayName("resourseNotFoundException should return 404 NOT_FOUND status")
    void resourseNotFoundException_Returns404Status() {
        ResourceNotFound exception = new ResourceNotFound("Resource not found");

        ResponseEntity<?> response = exceptionHandleController.resourseNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    @DisplayName("resourseNotFoundException should return ErrorResponse body")
    void resourseNotFoundException_ReturnsErrorResponseBody() {
        String errorMessage = "Usuario no encontrado con id: 1";
        ResourceNotFound exception = new ResourceNotFound(errorMessage);

        ResponseEntity<?> response = exceptionHandleController.resourseNotFoundException(exception);

        assertNotNull(response.getBody());
        assertTrue(response.getBody() instanceof ErrorResponse);

        ErrorResponse errorResponse = (ErrorResponse) response.getBody();
        assertEquals(HttpStatus.NOT_FOUND.value(), errorResponse.getStatus());
        assertEquals(errorMessage, errorResponse.getMessage());
        assertNotNull(errorResponse.getTime());
    }

    @Test
    @DisplayName("resourseNotFoundException should include timestamp in response")
    void resourseNotFoundException_IncludesTimestamp() {
        ResourceNotFound exception = new ResourceNotFound("Test error");

        ResponseEntity<?> response = exceptionHandleController.resourseNotFoundException(exception);

        ErrorResponse errorResponse = (ErrorResponse) response.getBody();
        assertNotNull(errorResponse);
        assertNotNull(errorResponse.getTime());
    }
}
