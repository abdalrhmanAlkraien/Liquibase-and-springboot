package com.abdalrhman.liquibase_article.service;

import com.abdalrhman.liquibase_article.model.User;
import com.abdalrhman.liquibase_article.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User createUser(
            final User user
    ) {

        return userRepository.saveAndFlush(user);
    }

    public User updateUser(
            final User user
    ) throws Exception {
        if (user.getId() == null) {
            throw new Exception("user does not exist");
        }

        return userRepository.saveAndFlush(user);
    }

    public User getUserById(
            final Long userId
    ) throws Exception {

        return userRepository
                .findById(userId)
                .orElseThrow(Exception::new);
    }

    public void deleteUser(
            final Long userId
    ) throws Exception {

        if (!userRepository.findById(userId).isPresent()) {

            throw new Exception("user does not exist");
        } else {

            userRepository.deleteById(userId);
        }
    }
}
