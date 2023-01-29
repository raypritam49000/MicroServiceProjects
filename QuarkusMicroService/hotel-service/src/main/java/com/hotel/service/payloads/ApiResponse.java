package com.hotel.service.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ws.rs.core.Response;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private Response.Status status;
    private Integer statusCode;
    private Boolean success;
    private String path;
    private String timestamp;
}
