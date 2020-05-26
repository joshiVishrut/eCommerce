package eka.backend.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eka.backend.api.viewmodel.Response;
import eka.backend.model.User;
import eka.backend.service.UserDAO;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @GetMapping("/get/all")
    public Response<User> getAllUsers() {
        Response<User> response; 
        List<User> users = this.userDAO.getAllUsers();
        if (users.isEmpty()) {
            response = new Response<>("error", "get: empty db");
        }
        else {
            response = new Response<>(users, "array", "get: success");
        }
        return response;
    }

    @GetMapping("/get/{username}")
    public Response<User> getUserByUsername(@PathVariable("username") String username) {
        Response<User> response;
        try {
            List<User> user = new ArrayList<>(Arrays.asList(this.userDAO.getUserByUsername(username)));
            response = new Response<>(user, "success", "get: user found");
        }
        catch(Exception e) {
            response = new Response<>("error", "get: user not found");
        }
        return response;
    }

    @PutMapping("/put")
    public Response<User> createUserInDB(@RequestBody User user) {
        Response<User> response;
        try {
            this.userDAO.createUser(user);
            response = new Response<>("success", "put: user created");
        }
        catch(Exception e) {
            response = new Response<>("error", "put: user not created");
        }
        return response;
    }

    @PostMapping("/post")
    public Response<User> updateUserInDB(@RequestBody User user) {
        Response<User> response;
        try {
            this.userDAO.updateUser(user);
            response = new Response<>("success", "post: user updated");
        }
        catch(Exception e) {
            response = new Response<>("error", "post: user not updated");
        }
        return response;
    }

    @DeleteMapping("/delete/{username}")
    public Response<User> deleteUser(@PathVariable("username") String username) {
        Response<User> response;
        try {
            this.userDAO.deleteUser(username);
            response = new Response<>("success", "delete: user deleted");
        }
        catch(Exception e) {
            response = new Response<>("error", "delete: user not found");
        }
        return response;
    }
}