package com.mall.management.service;

import com.mall.management.entity.User;
import java.util.List;

public interface UserService {
    User addUser(User user);

    User updateUser(User user);

    User searchUser(Integer id);

    List<User> getAllUsers();

    boolean deleteUser(Integer id);

    User login(User user); // Added basic login signature

    boolean logout();
}
