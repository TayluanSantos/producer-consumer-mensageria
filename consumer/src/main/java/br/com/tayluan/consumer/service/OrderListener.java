package br.com.tayluan.consumer.service;

import br.com.tayluan.consumer.dto.OrderDTO;
import br.com.tayluan.consumer.model.Order;
import br.com.tayluan.consumer.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderListener {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @RabbitListener(queues = "${QUEUE_NAME}")
    public void receiveAndSaveOrder(@Payload OrderDTO orderDTO){
        String message = orderDTO.toString();

        Order order = modelMapper.map(orderDTO, Order.class);
        repository.save(order);

        System.out.println(message);
    }
}
