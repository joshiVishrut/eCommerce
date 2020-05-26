package eka.backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import eka.backend.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}