package com.bs280.teami.services;

import com.bs280.teami.models.User;
import com.bs280.teami.repositories.UserRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public User create(@Valid @NotNull User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser !=null) {
            throw new IllegalArgumentException("Username is already taken");
        }
        // If username is not taken, proceed to save the user
        return userRepository.save(user);
    }


    public User get(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        /**
         * TODO: Cascade delete
         */
        userRepository.deleteById(id);
    }


    public User update(Long id, User user) {
        /**
         * TODO: Add validation that all attributes are passed in, otherwise return 400
         */
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        User existingUser = existingUserOptional.get();
        BeanUtils.copyProperties(user, existingUser, "speaker_id");
        return userRepository.saveAndFlush(existingUser);
    }
}
