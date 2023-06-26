package com.bs280.teami.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs280.teami.libraries.UserInput;
import com.bs280.teami.models.User;
import com.bs280.teami.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
    }

    public User create(UserInput userInput) {
        User user = new User(userInput.getUsername(), userInput.getPassword());
        return userRepository.saveAndFlush(user);
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
        User existingUser = userRepository.getReferenceById(id);
        BeanUtils.copyProperties(user,existingUser,"speaker_id");
        return userRepository.saveAndFlush(existingUser);
    }
}
