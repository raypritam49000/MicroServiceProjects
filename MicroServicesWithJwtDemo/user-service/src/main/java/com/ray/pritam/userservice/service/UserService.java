package com.ray.pritam.userservice.service;

import com.ray.pritam.userservice.entity.User;
import com.ray.pritam.userservice.vo.ResponseTemplateVO;
import org.bson.types.ObjectId;

public interface UserService {
    public User save(User user);
    public User getById(ObjectId id);
    public ResponseTemplateVO getUserWithDepartment(String id);
}
