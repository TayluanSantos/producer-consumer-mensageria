package br.com.tayluan.consumer.service;

import br.com.tayluan.consumer.dto.OrderDTO;
import br.com.tayluan.consumer.model.Order;
import br.com.tayluan.consumer.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public List <OrderDTO> findAll(){
        List <Order> orderList = repository.findAll();
        List <OrderDTO> orderListDTO = orderList.stream()
                .map(order -> modelMapper.map(order, OrderDTO.class))
                .collect(Collectors.toList());

        return orderListDTO;
    }
}
