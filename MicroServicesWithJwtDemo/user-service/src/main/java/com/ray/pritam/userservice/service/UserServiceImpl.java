package com.ray.pritam.userservice.service;

import com.ray.pritam.userservice.entity.User;
import com.ray.pritam.userservice.repository.UserRepository;
import com.ray.pritam.userservice.vo.Department;
import com.ray.pritam.userservice.vo.ResponseTemplateVO;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getById(ObjectId id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(String id) {
        User user = this.getById(new ObjectId(id));
        Department department = restTemplate.getForObject("http://Department-Service/departments/" +Long.parseLong(String.valueOf(user.getDepartmentId())), Department.class);
        return new ResponseTemplateVO(user, department);
    }
}
