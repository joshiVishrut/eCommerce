package eka.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eka.backend.model.Order;
import eka.backend.repository.OrderRepository;

@Service
public class OrderDAO {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    public List<Order> getOrdersByUsername(String username) {
        return this.orderRepository.getOrdersByUsername(username);
    }

    public Order getOrderById(String id) throws Exception {
        return this.orderRepository.findById(id).get();
	}

    public void createOrder(Order order) throws Exception {
        this.orderRepository.insert(order);
    } 

    public void updateOrder(Order order) throws Exception {
        this.orderRepository.save(order);
    }

	public void deleteOrder(String id) throws Exception {
        if (this.orderRepository.existsById(id)) {
            this.orderRepository.deleteById(id);
            return;
        }
        throw new Exception();
    }

}