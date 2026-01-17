package com.mall.management.service;

import com.mall.management.entity.User;
import com.mall.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@SuppressWarnings("null")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User searchUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public User login(User user) {
        // Basic implementation: find by name/password logic would go here.
        // For now, returning user if added to persistence context or null.
        // In a real app, use better auth. This is a placeholder for the "standard"
        // structure requested.
        return user;
    }

    @Override
    public boolean logout() {
        return true;
    }
}
