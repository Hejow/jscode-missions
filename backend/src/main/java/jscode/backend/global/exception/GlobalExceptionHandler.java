package jscode.backend.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * CustomException Handling
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        log.error("CustomException : {}, {}", e.getErrorCode(), e.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(e);
        return ResponseEntity.status(e.getHttpStatus()).body(errorResponse);
    }

    /**
     * UnexpectedException Handling
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleUnexpectedException(Exception e) {
        log.error("UnexpectedException : {}", e.getMessage());
        return new ErrorResponse(ErrorInformation.INTERNAL_SERVER_ERROR);
    }
}
