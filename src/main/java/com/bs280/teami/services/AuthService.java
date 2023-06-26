package com.bs280.teami.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs280.teami.libraries.JwtTokenization;
import com.bs280.teami.libraries.TokenizationPayload;
import com.bs280.teami.libraries.UserInput;
import com.bs280.teami.libraries.utils.Bs280Exception;
import com.bs280.teami.libraries.utils.ErrorScope;
import com.bs280.teami.models.User;
import com.bs280.teami.repositories.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenization jwtTokenization;

    public List<User> list() {
        return userRepository.findAll();
    }

    public String sign(UserInput userInput) {
        // User user = new User(userInput.getUsername(), userInput.getPassword());
        User user = userRepository.findByUsername(userInput.getUsername());

        if (user == null) {
            throw new Bs280Exception("Invalid credentials", 401, ErrorScope.CLIENT);
        }

        Boolean isPasswordMatch = user.isPasswordMatch(userInput.getPassword());


        if(isPasswordMatch == false) {
            throw new Bs280Exception("Invalid credentials", 401, ErrorScope.CLIENT);
        }

        TokenizationPayload payload = new TokenizationPayload(user.getUserId(), user.getUsername());
        
        return this.jwtTokenization.sign(payload);
    }

    public Boolean verify(String token) {
        return this.jwtTokenization.verify(token);

        /**
         * TODO CHECK PAYLOAD
         */
    }
}
