package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.entities.Order;
import com.example.demoProgettoLibreriaSpring.repositories.OrderRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    public Order getOrderByClientNameAndClientSurname(String clientName, String clientSurname) throws Exception {
        Optional<Order> optionalOrder = orderRepository.findOrderByClientNameAndClientSurname(clientName, clientSurname);
        if (optionalOrder.isPresent()){
            return optionalOrder.get();
        }else throw new Exception("Order with Client Name :  " + clientName + " " +clientSurname+ " does not exist");
    }

    public Order getOrderByClientNumber(String clientNumber) throws Exception {
        Optional<Order> optionalOrder = orderRepository.findOrderByClientNumber(clientNumber);
        if (optionalOrder.isPresent()){
            return optionalOrder.get();
        }else throw new Exception("Order with Client cell number :  " +clientNumber+ " does not exist");
    }

    public Order getOrderByClientEmail(String clientEmail) throws Exception {
        Optional<Order> optionalOrder = orderRepository.findOrderByClientEmail(clientEmail);
        if (optionalOrder.isPresent()){
            return optionalOrder.get();
        }else throw new Exception("Order with Client Email :  " + clientEmail+ " does not exist");
    }

    public String saveOrder(Order order) throws Exception {
        try {
            orderRepository.save(order);
            return "The new order has been created "+ order;
        } catch (Exception e) {
            throw new Exception("Couldn't create order. Check if everything is all right!");
        }
    }

    public String deleteOrderById(long id) throws Exception {
        try {
            orderRepository.deleteById(id);
            return "The order: " +id+ " has been deleted!";
        } catch (Exception e) {
            throw new Exception("Cannot find any order with ID: "+id);
        }
    }

    public void updateOrder(){
        //voglio fare in modo che si possa fare l'update di tutto
        //Email, numero di cell, aggiungere/togliere libri.
        //chiedo a carlo se è meglio dividerlo come per il get
        //o se posso farlo senza problemi in un unica soluzione
    }
}
