package jscode.backend.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String message;

    public CustomException(ErrorInformation errorInformation) {
        this.httpStatus = errorInformation.getHttpStatus();
        this.errorCode = errorInformation.toString();
        this.message = errorInformation.getMessage();
    }
}
