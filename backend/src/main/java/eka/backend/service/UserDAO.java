package eka.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eka.backend.model.User;
import eka.backend.repository.UserRepository;

@Service
public class UserDAO {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserByUsername(String username) throws Exception {
        return this.userRepository.findById(username).get();
    }

    public void createUser(User user) throws Exception {
        this.userRepository.insert(user);
    }

    public void updateUser(User user) throws Exception {
        this.userRepository.save(user);
    }

    public void deleteUser(String username) throws Exception {
        if (this.userRepository.existsById(username)) {
            this.userRepository.deleteById(username);
            return;
        }
        throw new Exception();
    }

}