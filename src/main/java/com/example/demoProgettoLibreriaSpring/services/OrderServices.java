package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.DTO.BookDTO;
import com.example.demoProgettoLibreriaSpring.DTO.OrderDTO;
import com.example.demoProgettoLibreriaSpring.entities.Book;
import com.example.demoProgettoLibreriaSpring.entities.Order;
import com.example.demoProgettoLibreriaSpring.repositories.BookRepository;
import com.example.demoProgettoLibreriaSpring.repositories.OrderRepository;
import com.example.demoProgettoLibreriaSpring.repositories.WarehouseRepository;
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

    @Autowired
    private BookServices bookServices;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private WarehouseRepository warehouseRepository;

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

    public Order saveOrder(OrderDTO orderDTO) throws Exception {
        try {
            Order order = new Order(
                    orderDTO.getClientName(),
                    orderDTO.getClientSurname(),
                    orderDTO.getClientEmail(),
                    orderDTO.getClientNumber());
            //for (String bookName : orderDTO.getBookNames()) {
            //    order.addBook(bookServices.getBookByTitle(bookName).get(0));
            //}
            for (long id : orderDTO.getBookIds()) {
                Optional<Book> optional = bookRepository.findById(id);
                if (optional.isPresent()) {
                    order.addBook(optional.get());
                }else {
                    throw new Exception("Cannot find book with id " + id);
                }
            }
            // TODO gestire il caso in cui non trovo il magazzino (optional)
            order.setWarehouse(warehouseRepository.findById(orderDTO.getWarehouseId()).get());
            order = orderRepository.save(order);
            return order;
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

//    public Optional<Order> updateOrderClientNumber(long id, String clientNewNumber) throws Exception {
//        try {
//            Optional<Order> orderToBeUpdated = orderRepository.findById(id);
//            if (orderToBeUpdated.isPresent()) {
//                orderToBeUpdated.get().setClientNumber(clientNewNumber);
//                orderRepository.save(orderToBeUpdated);
//                return orderToBeUpdated;
//        }
//        } catch (Exception e) {
//            throw new Exception("Cannot find Order with ID : "+id);
//        }
//    }


    public Order updateOrder( long id, Order orderDetails) throws Exception {
        try {
            Order updateOrder = orderRepository.getReferenceById(id);

            updateOrder.setClientName(orderDetails.getClientName());
            updateOrder.setClientSurname(orderDetails.getClientSurname());
            updateOrder.setClientEmail(orderDetails.getClientEmail());
            updateOrder.setClientNumber(orderDetails.getClientNumber());

            orderRepository.save(updateOrder);

            return updateOrder;
        } catch (Exception e) {
            throw new Exception("Cannot find Order with ID : "+id);
        }
    }
}
