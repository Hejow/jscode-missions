package jscode.backend.global.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonPropertyOrder({"httpStatus", "errorCode", "message"})
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    public ErrorResponse(CustomException exception) {
        this.httpStatus = exception.getHttpStatus();
        this.errorCode = exception.getErrorCode();
        this.message = exception.getMessage();
    }

    public ErrorResponse(ErrorInformation information) {
        this.httpStatus = information.getHttpStatus();
        this.errorCode = information.toString();
        this.message = information.getMessage();
    }

    public ErrorResponse(ErrorInformation information, String message) {
        this.httpStatus = information.getHttpStatus();
        this.errorCode = information.toString();
        this.message = message;
    }
}
