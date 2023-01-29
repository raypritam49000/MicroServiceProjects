package com.api.gateway.dto;

import com.api.gateway.entity.User;

public class AuthResponse {
    private String accessToken;

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public AuthResponse() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}