package com.grupo9.db.util;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@JsonPropertyOrder({ "httpHeaders", "httpStatusCode", "message", "data", "otherParams" })
public class ApiResponse<T> {

    private final int httpStatusCode;
    private final String message;
    private final T data;

    private ApiResponse(ApiResponseBuilder builder) {
        this.httpStatusCode = builder.httpStatusCode;
        this.message = builder.message;
        this.data = (T) builder.data;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }


    public static class ApiResponseBuilder<T> {

        private final int httpStatusCode;
        private final String message;
        private T data;

        public ApiResponseBuilder(int httpStatusCode, String message) {
            this.httpStatusCode = httpStatusCode;
            this.message = message;
        }

        public ApiResponseBuilder<T> withData(T data) {
            this.data = data;
            return this;
        }

        public ResponseEntity<ApiResponse> build() {
            ApiResponse<T> apiResponse = new ApiResponse<>(this);
            return ResponseEntity.status(apiResponse.getHttpStatusCode()).body(apiResponse);
        }
    }
}