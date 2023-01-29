package com.api.gateway.service;

import com.api.gateway.entity.User;

public interface ILoginService {
    public String login(String username,String password);
    public User saveUser(User user);
    public boolean logout(String token);
    public Boolean isValidToken(String token);
    public String createNewToken(String token);
}
