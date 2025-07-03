package school.sorokin.notificationmanager.exceptions;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorMessageResponse> handleIllegalArgumentException(Exception exception) {

        log.error("Handle bad request exception", exception);
        var messageResponse = new ErrorMessageResponse(
                "Bad request",
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(messageResponse);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorMessageResponse> handleException(Exception exception) {

        log.error("Handle common exception", exception);
        var messageResponse = new ErrorMessageResponse(
                "Server Error",
                exception.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(messageResponse);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class, NoResourceFoundException.class})
    public ResponseEntity<ErrorMessageResponse> handleEntityNotFoundException(Exception e) {

        log.error("Handle entity not found exception", e);
        var messageResponse = new ErrorMessageResponse(
                "Entity not found",
                e.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(messageResponse);
    }

    @ExceptionHandler(value = BadCredentialsException.class)
    public ResponseEntity<ErrorMessageResponse> handleBadCredentialsException(BadCredentialsException e) {

        log.error("Handle authorization exception", e);
        var messageResponse = new ErrorMessageResponse(
                "Failed to authenticate",
                e.getMessage(),
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(messageResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorMessageResponse> handleValidateException(ConstraintViolationException e) {
        log.error("Handle Bad request exception: ConstraintViolationException = {}", e.getConstraintViolations());
        String detailMessage = e.getConstraintViolations()
                .stream()
                .map(error -> String.format("%s %s %s Rejected value: %s",
                        error.getRootBeanClass().getSimpleName(), error.getPropertyPath(),
                        error.getMessage(), error.getInvalidValue())
                ).collect(Collectors.joining(", "));

        var error = new ErrorMessageResponse(
                "Bad request. Argument is NULL",
                detailMessage,
                LocalDateTime.now()
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
