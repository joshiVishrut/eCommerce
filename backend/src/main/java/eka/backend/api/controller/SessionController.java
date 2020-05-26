package eka.backend.api.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eka.backend.api.viewmodel.Response;
import eka.backend.model.User;

@RestController
@RequestMapping("/session")
@CrossOrigin
public class SessionController {
    User loggedInUser;
    @Autowired
    UserController userController;

    SessionController() {
        this.loggedInUser = null;
    }

    @GetMapping("/isloggedin")
    public Response<User> isLoggedIn() {
        Response<User> response;
        if (loggedInUser == null) {
            response = new Response<>("error", "No logged in user");
        }
        else {
            response = new Response<>(new ArrayList<>(Arrays.asList(this.loggedInUser)), "session", "user logged in");
        }
        return response;
    }

    @GetMapping("/isadmin")
    public Response<Boolean> isAdmin() {
        if (this.loggedInUser == null) {
            return new Response<>("error", "no one is logged in");
        }
        if (this.loggedInUser.getRole().equals("admin")) {
            return new Response<>("true", "user role: admin");
        }
        return new Response<>("false", "user role: user");
    } 

    @PostMapping("/login")
    public Response<User> loginUser(@RequestBody User user) {
        Response<User> response;
        Response<User> userDBResponse = this.userController.getUserByUsername(user.getUsername());
        if (userDBResponse.getType() == "error") {
            response = new Response<>("error", "user not found");
            return response;
        }
        if (user.getPassword().equals(userDBResponse.getData().get(0).getPassword())) {
            this.loggedInUser = userDBResponse.getData().get(0);
            response = new Response<>(userDBResponse.getData(), "session", "user logged in");
        }
        else {
            response = new Response<>("error", "invalid password");
        }
        return response;
    }

    @GetMapping("/logout")
    public Response<User> logoutUser() {
        this.loggedInUser = null;
        return new Response<>("success", "user logged out");
    }
}