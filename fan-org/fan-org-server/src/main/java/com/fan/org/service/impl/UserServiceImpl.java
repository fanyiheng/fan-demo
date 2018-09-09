package com.fan.org.service.impl;

import com.fan.org.entity.User;
import com.fan.org.service.UserService;
import org.springframework.data.domain.Page;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUserById(Integer userId) {

    }

    @Override
    public User getById(Integer userId) {
        return null;
    }

    @Override
    public User getByUserCode(String userCode) {
        return null;
    }

    @Override
    public User getByUserName(String userName) {
        return null;
    }

    @Override
    public List<User> findByQuery() {
        return null;
    }

    @Override
    public Page<User> findPageByQuery() {
        return null;
    }
}
