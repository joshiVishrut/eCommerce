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

import eka.backend.model.Order;
import eka.backend.api.viewmodel.Response;
import eka.backend.service.OrderDAO;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderDAO orderDAO;

    @GetMapping("/get/all")
    public Response<Order> getAllOrders() {
        Response<Order> response; 
        List<Order> orders = this.orderDAO.getAllOrders();
        if (orders.isEmpty()) {
            response = new Response<>("error", "get: empty db");
        }
        else {
            response = new Response<>(orders, "array", "get: success");
        }
        return response;
    }

    @GetMapping("/get/user/{username}")
    public Response<Order> getOrdersByUsername(@PathVariable("username") String username) {
        Response<Order> response; 

        List<Order> orders = this.orderDAO.getOrdersByUsername(username);
        if (orders.isEmpty()) {
            response = new Response<>("error", "get: empty db");
        }
        else {
            response = new Response<>(orders, "array", "get: success");
        }

        return response;
    }

    @GetMapping("/get/{id}")
    public Response<Order> getOrderById(@PathVariable("id") String id) {
        Response<Order> response;
        try {
            List<Order> order = new ArrayList<>(Arrays.asList(this.orderDAO.getOrderById(id)));
            response = new Response<>(order, "success", "get: order found");
        }
        catch(Exception e) {
            response = new Response<>("error", "get: order not found");
        }
        return response;
    }

    @PutMapping("/put")
    public Response<Order> createOrder(@RequestBody Order order) {
        Response<Order> response;
        try {
            this.orderDAO.createOrder(order);
            response = new Response<>("success", "put: order created");
        }
        catch(Exception e) {
            response = new Response<>("error", "put: order not created");
        }
        return response;
    }

    @PostMapping("/post")
    public Response<Order> updateOrder(@RequestBody Order order) {
        Response<Order> response;
        try {
            this.orderDAO.updateOrder(order);
            response = new Response<>("success", "post: order updated");
        }
        catch(Exception e) {
            response = new Response<>("error", "post: order not updated");
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public Response<Order> deleteOrder(@PathVariable("id") String id) {
        Response<Order> response;
        try {
            this.orderDAO.deleteOrder(id);
            response = new Response<>("success", "delete: order deleted");
        }
        catch(Exception e) {
            response = new Response<>("error", "delete: order not deleted");
        }
        return response;
    }
}