package com.grupo9.db.util;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponsesBuilder<T> {

    public ResponseEntity<ApiResponse<Object>> buildResponse(
            int httpStatusCode, String message, Object data, Object errors) {
        return new ApiResponse.ApiResponseBuilder <> (httpStatusCode, message)
                .withData(data).withErrors(errors).build();
    }


}