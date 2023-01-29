package com.dailycodebuffer.user.vo;

import com.dailycodebuffer.user.entity.User;

public class ResponseTemplateVo {
    private User user;
    private Department department;

    public ResponseTemplateVo() {
    }

    public ResponseTemplateVo(User user, Department department) {
        this.user = user;
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "ResponseTemplateVo{" +
                "user=" + user +
                ", department=" + department +
                '}';
    }
}
