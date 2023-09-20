package br.com.tayluan.consumer.controller;

import br.com.tayluan.consumer.dto.OrderDTO;
import br.com.tayluan.consumer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order-consumer")
public class OrderController {
    @Autowired
    private OrderService service;
    @GetMapping
    private List <OrderDTO> listOrders(){
        return service.findAll();
    }
}
