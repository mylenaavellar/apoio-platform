package com.apoio.apoio_api.service;

import com.apoio.apoio_api.dto.user.UserRequest;
import com.apoio.apoio_api.dto.user.UserResponse;
import com.apoio.apoio_api.entity.User;
import com.apoio.apoio_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(UUID id, UserRequest userDetails) {
        User userFromDb = getUserById(id);

        userDetails.toEntityUpdate(userFromDb);

        return userRepository.save(userFromDb);
    }

    public void deleteUser(UUID id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
