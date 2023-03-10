package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.service.AmazonClient;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage/")
public class BucketController {

    private AmazonClient amazonClient;

    @Autowired
    private ResponsesBuilder responsesBuilder;

    @Autowired
    BucketController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<String, Object>> uploadFile(@RequestPart(value = "file") MultipartFile file) throws BadRequestException {
        String response = this.amazonClient.uploadFile(file);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Image uploaded successfully", response, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/deleteFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<String, Object>>  deleteFile(@RequestPart(value = "url") String fileUrl) throws ResourceNotFoundException {
        String response = this.amazonClient.deleteFileFromS3Bucket(fileUrl);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Image deleted successfully",response, null);
    }
}
