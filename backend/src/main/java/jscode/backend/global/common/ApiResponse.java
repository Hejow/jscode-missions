package jscode.backend.global.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonPropertyOrder({"message", "payload"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private static final String SUCCESS = "성공적으로 요청을 수행했습니다.";
    private final String message;
    private final T payload;

    @Builder
    public ApiResponse(String message, T payload) {
        this.message = message;
        this.payload = payload;
    }

    public static <T> ApiResponse success(T payload) {
        return ApiResponse.builder()
                .payload(payload)
                .message(SUCCESS)
                .build();
    }

    public static <T> ApiResponse noContent() {
        return ApiResponse.builder()
                .message(SUCCESS)
                .build();
    }
}
