package com.example.java.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private String status;
    private String message;
    private Object data;

    // Constructor for success response
    public ApiResponse(String message, Object data) {
        this.status = "SUCCESS";
        this.message = message;
        this.data = data;
    }

    // Constructor for error response
    public ApiResponse(String message) {
        this.status = "ERROR";
        this.message = message;
        this.data = null;
    }
}
