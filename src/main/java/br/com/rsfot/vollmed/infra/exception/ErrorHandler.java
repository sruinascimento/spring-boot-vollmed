package br.com.rsfot.vollmed.infra.exception;

import br.com.rsfot.vollmed.infra.personalizade.exception.DoctorNotFoundException;
import br.com.rsfot.vollmed.infra.personalizade.exception.PatientNotFoundException;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(DoctorNotFoundException.class)
    public ResponseEntity<String> handleDoctorNotFoundException(DoctorNotFoundException exception) {
        return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> handlePatientNotFoundException(PatientNotFoundException exception) {
        return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<FieldErrorResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<FieldErrorResponse> fieldErrorsResponse = fieldErrors.stream().map(FieldErrorResponse::new).toList();
        return ResponseEntity.badRequest().body(fieldErrorsResponse);
    }

    private record FieldErrorResponse(String field, String message) {
        public FieldErrorResponse(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
