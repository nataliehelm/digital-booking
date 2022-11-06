package com.grupo9.db.exceptions;

import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    private static Logger logger = Logger.getLogger(GlobalExceptions.class);
    private ResponsesBuilder responsesBuilder;

    public GlobalExceptions(ResponsesBuilder responsesBuilder) {
        this.responsesBuilder = responsesBuilder;
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ApiResponse> notFoundHandler(ResourceNotFoundException ex){
        String errorDescription = "ERROR: Description: " + ex.getMessage() + '\n' + "Location: " + '\n' + ex.getStackTrace()[0] + '\n' + ex.getStackTrace()[1] + '\n' + ex.getStackTrace()[2] + '\n' + '\n';
        logger.error(errorDescription);
        return responsesBuilder.buildResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage(), "", null);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ApiResponse> badRequestHandler(BadRequestException ex){
        String errorDescription = "ERROR: Description: " + ex.getMessage() + '\n' + "Location: " + '\n' + ex.getStackTrace()[0] + '\n' + ex.getStackTrace()[1] + '\n' + ex.getStackTrace()[2] + '\n' + '\n';
        logger.error(errorDescription);
        return responsesBuilder.buildResponse(HttpStatus.BAD_REQUEST.value(),ex.getMessage(), "", null);
    }

    @ExceptionHandler({ReferentialIntegrityException.class})
    public ResponseEntity<ApiResponse> referentialIntegrityHandler(ReferentialIntegrityException ex){
        String errorDescription = "ERROR: Description: " + ex.getMessage() + '\n' + "Location: " + '\n' + ex.getStackTrace()[0] + '\n' + ex.getStackTrace()[1] + '\n' + ex.getStackTrace()[2] + '\n' + '\n';
        logger.error(errorDescription);
        return responsesBuilder.buildResponse(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage(), "", null);
    }

}
