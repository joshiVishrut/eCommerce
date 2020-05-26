package eka.backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import eka.backend.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    @Query(value = "{username:?0}")
    List<Order> getOrdersByUsername(String username);
}