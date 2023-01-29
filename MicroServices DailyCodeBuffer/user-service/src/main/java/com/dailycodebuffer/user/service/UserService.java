package com.dailycodebuffer.user.service;

import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.vo.ResponseTemplateVo;

public interface UserService {
    public User saveUser(User user);
    public ResponseTemplateVo getUserWithDepartment(Long userId);
}
