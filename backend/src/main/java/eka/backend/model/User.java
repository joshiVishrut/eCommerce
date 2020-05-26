package eka.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usersDB")
public class User {
    @Id
    private String username;
    private String password;
    private String role;

    public User(@JsonProperty("username") String username,
    @JsonProperty("password") String password,
    @JsonProperty("role") String role ) {
        this.username = username;
        this.password = password;
        this.role = "user";
        if (role != null) {
            this.role = role;
        }
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRole() {
        return this.role;
    }
}