package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.entities.Order;
import com.example.demoProgettoLibreriaSpring.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @GetMapping("/all")
    public List<Order> getAllOrder(){
        return orderServices.getAllOrders();
    }

    @GetMapping("/clientName")
    public ResponseEntity getOrderByClientName(@RequestParam String clientName, @RequestParam String clientSurname) throws Exception {
        try {
            Optional<Order> name = Optional.ofNullable(orderServices.getOrderByClientName(clientName, clientSurname));
            return ResponseEntity.ok(name);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/clientNumber")
    public ResponseEntity getOrderByClientNumber(@RequestParam String clientNumber) throws Exception {
        try {
            Optional<Order> number = Optional.ofNullable(orderServices.getOrderByClientNumber(clientNumber));
            return ResponseEntity.ok(number);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/clientEmail")
    public ResponseEntity getOrderByClientEmail(@RequestParam String clientEmail) throws Exception {
        try {
            Optional<Order> email = Optional.ofNullable(orderServices.getOrderByClientEmail(clientEmail));
            return ResponseEntity.ok(email);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/save")
    public void saveOrder(@RequestBody Order order) throws Exception {
        orderServices.saveOrder(order);
    }

    @DeleteMapping("/delete")
    public void deleteOrderById(@RequestParam long id) throws Exception {
        orderServices.deleteOrderById(id);
    }


    // public void updateOrder(){}
    // chiedi a carlo, vedi OrderServices.
}
