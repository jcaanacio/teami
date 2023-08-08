package com.bs280.teami.models;
import jakarta.persistence.*;

import com.bs280.teami.libraries.Argon2PassEncoder;
import com.bs280.teami.libraries.interfaces.IPasswordEncoder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(unique = true)
    private String username;
    private String password;

    
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        setPassword(password);
    }

    public Long getUserId() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        IPasswordEncoder passwordEncoder = new Argon2PassEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public boolean isPasswordMatch(String inputPassword) {
        IPasswordEncoder passwordEncoder = new Argon2PassEncoder();
        return passwordEncoder.isPasswordMatch(inputPassword, this.password);
    }
}
