package com.fan.org.service;

import com.fan.org.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User addUser(User user);
    User updateUser(User user);
    void deleteUserById(Integer userId);
    User getById(Integer userId);
    User getByUserCode(String userCode);
    User getByUserName(String userName);
    List<User> findByQuery();
    Page<User> findPageByQuery();
}
