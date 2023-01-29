package com.dailycodebuffer.user.service.impl;

import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.repository.UserRepository;
import com.dailycodebuffer.user.service.UserService;
import com.dailycodebuffer.user.vo.Department;
import com.dailycodebuffer.user.vo.ResponseTemplateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public ResponseTemplateVo getUserWithDepartment(Long userId) {
        ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
        responseTemplateVo.setUser(user);
        responseTemplateVo.setDepartment(department);
        return responseTemplateVo;
    }


}
